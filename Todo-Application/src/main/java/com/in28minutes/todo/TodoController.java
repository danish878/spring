package com.in28minutes.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.exception.ExceptionController;

@Controller
@SessionAttributes("name")
public class TodoController {

    private Log logger = LogFactory.getLog(ExceptionController.class);

    @Autowired
    TodoService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listTodos(ModelMap model) {
        model.addAttribute("todos", service.retrieveTodos(retrieveLoggedInUserName()));
        return "list-todos";
    }

    private String retrieveLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model) {
        throw new RuntimeException("Dummy Exception");
//		model.addAttribute("todo", new Todo());
//		return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String showTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        service.addTodo(retrieveLoggedInUserName(), todo.getDesc(), new Date(), false);
        model.clear(); // to prevent request parameter "name" to be passed
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodoPage(ModelMap model, @RequestParam int id) {
        service.deleteTodo(id);
//		model.clear(); // to prevent request parameter "name" to be passed
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodo(ModelMap model, @RequestParam int id) {
        Todo todo = service.retrieveTodo(id);
        model.addAttribute("todo", todo);

        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(retrieveLoggedInUserName());
        service.updateTodo(todo);

        return "redirect:/list-todos";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        logger.error(String.format("Request: %s - threw an exception: %s", request.getRequestURI(), ex));
        return "error-specific";
    }

}
