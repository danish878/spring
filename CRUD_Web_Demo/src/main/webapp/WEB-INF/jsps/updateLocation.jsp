<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create Location</title>
    </head>
    <body>

        <form action="updateLocation" method="post">
    <pre>
        ID: <input type="text" name="id" value="${location.id}" readonly/>
        Code: <input type="text" name="code" value="${location.code}"/>
        Name: <input type="text" name="name" value="${location.name}"/>
        Type: Urban <input type="radio" name="type" value="URBAN" ${location.type == 'URBAN'?'checked':''}/>
              Rural <input type="radio" name="type" value="RURAL" ${location.type == 'RURAL'?'checked':''}/>
        <input type="submit" value="Update"/>
    </pre>
        </form>

    </body>
</html>