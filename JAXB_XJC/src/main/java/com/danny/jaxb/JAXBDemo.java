package com.danny.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.danny.patient.Patient;

public class JAXBDemo {

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Patient.class);
        Marshaller marshaller = context.createMarshaller();

        Patient patient = new Patient();
        patient.setId(7);
        patient.setName("Danny");
        patient.setAge(26);

        StringWriter writer = new StringWriter();

        marshaller.marshal(patient, writer);

        System.out.println(writer.toString());


        Unmarshaller unmarshaller = context.createUnmarshaller();
        Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));

        System.out.println(patientResult);

    }

}
