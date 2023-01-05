package com.solvd.hospital.departament;
import com.solvd.hospital.Main;
import com.solvd.hospital.disease.AttackOfSarcasm;
import com.solvd.hospital.disease.Disease;
import com.solvd.hospital.disease.MethodOfTreatment;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import com.solvd.hospital.exception.NumberHospitalException;
import com.solvd.hospital.model.Patient;
import com.solvd.hospital.model.Person;
import com.solvd.hospital.privateObject.PrivateObject;
import com.solvd.hospital.service.DataGenerateService;
import com.solvd.hospital.service.PersonService;
import com.solvd.hospital.service.SpecialistService;
import com.solvd.hospital.specialty.Specialist;
import com.solvd.hospital.specialty.Therapist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Hospital{
    static Logger logger = LogManager.getLogger(Hospital.class);
    private int hospitalNumber;
    public ArrayList<Patient> hospitalPatients = new ArrayList<>();
    public HashSet<Specialist> hospitalSpecialists = new HashSet<>();
    public HashMap<Patient, Record> hospitalRecords = new HashMap<>();

    public Hospital() {
    }
    public int getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(int hospitalNumber) throws NumberHospitalException {
        if (hospitalNumber < 1 || hospitalNumber> 999) {
            throw new NumberHospitalException("Wrong hospital number. Write number in a 1 - 999 range");
        } else {
            this.hospitalNumber= hospitalNumber;
        }
    }

    static final int capacity = 100;

    public void menuPatientStart(Patient patient, PersonService personService){
        System.out.println("  *** PATIENTS MENU ***  ");
        SpecialistService specialistService = new SpecialistService();
        Scanner scanner = new Scanner(System.in);

        boolean isSelected = false;

        while (!isSelected) {
            System.out.println("1 - Create visit with specialist");
            System.out.println("2 - Show all specialists");
            System.out.println("3 - Exit");
            System.out.println("Enter number from 1 to 3: ");
            int menuNumber = 0;
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Menu number!");
                logger.error("Incorrect Menu number!" + e);
            }
            if (menuNumber == 1) {
                //isSelected = true;
                menuNumber = 1;
                System.out.println("User selected 1");
                Specialist selectedSpecialist = personService.selectSpecialistFromConsole();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                String date = LocalDate.now().format(formatter);
                specialistService.createVisit(selectedSpecialist, patient, date);
            }
            if (menuNumber == 2) {
                //isSelected = true;
                menuNumber = 2;
                System.out.println("User selected 2");
                hospitalSpecialists.forEach(s -> System.out.println(s.getFullContactByString()));
            }
            if (menuNumber == 3) {
                System.exit(0);
            }
        }
    }

    public void menuSpecialistStart(Specialist specialist, PersonService personService) {
        System.out.println("  *** SPECIALIST MENU ***  ");

        Scanner scanner = new Scanner(System.in);
        SpecialistService specialistService = new SpecialistService();
        boolean isSelected = false;

        while (!isSelected) {
            System.out.println("1 - Create visit with Patient");
            System.out.println("2 - Create new Patient");
            System.out.println("3 - Show all patients");
            System.out.println("4 - Exit");
            System.out.println("Enter number from 1 to 4: ");
            int menuNumber = 0;
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Menu number!");
                logger.error("Incorrect Menu number!" + e);
            }

            if (menuNumber == 1) {
                isSelected = true;
                menuNumber = 1;
                System.out.println("User selected 1");

                Patient selectedPatient = personService.selectPatientFromConsole();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                String date = LocalDate.now().format(formatter);
                specialistService.createVisit(specialist, selectedPatient, date);
            }

            if (menuNumber == 2) {
                //isSelected = true;
                menuNumber = 2;
                System.out.println("User selected 2");

                try {
                    hospitalPatients.add(personService.createPatientFromConsole());
                } catch (FirstNameException | LastNameException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Patient created");

            }
            if (menuNumber == 3) {
                //isSelected = true;
                menuNumber = 3;
                System.out.println("User selected 3");
                hospitalPatients.forEach(p -> System.out.println(p.getFullContactByString()));
            }
            if (menuNumber == 4) {
                System.exit(0);
            }
        }
    }

    public void menuAuthStart(){
        Scanner scanner = new Scanner(System.in);
        PersonService personService = new PersonService(hospitalPatients, hospitalSpecialists);

        boolean isLogin = false;
        while (!isLogin){
            System.out.println("Enter login or press 'Enter' to exit:");
            String login = scanner.nextLine();

            if (login.isEmpty()) {
                System.exit(0);
            }

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            if (personService.authorization(login, password)){
                isLogin = true;
                Person loginedPerson = personService.getPersonByLogin(login);
                System.out.println( "Welcome, " + loginedPerson.getFirstName());
                if (loginedPerson.getClass().getSimpleName().equals("Patient")){
                    menuPatientStart((Patient) loginedPerson, personService);
                }
                else {
                    menuSpecialistStart((Specialist) loginedPerson, personService);
                }
            }
            else {
                System.out.println("Incorrect login or pass.");
                System.out.println("Try again: ");
            }
        }

    }
    public void start() throws Exception{
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("Main Started");

        //Creating patient from console
        //Patient consolePatient = new Patient().createPatientFromConsole();

        DataGenerateService dataGenerateService = new DataGenerateService();
        hospitalPatients = dataGenerateService.dataGeneratePatients();
        hospitalRecords = dataGenerateService.dataGenerateRecords();
        hospitalSpecialists = dataGenerateService.dataGenerateSpecialists();

        /*
        //STREAMS
        //Filter
        hospitalPatients.stream()
                .filter(patient -> patient.getAge() > 18)
                .forEach(patient -> System.out.println("Patient 18+ : " + patient.getFirstName()));
        //ForEach
        hospitalPatients.stream().forEach(p -> {
            System.out.println("Generated patient: " + p.getFirstName());
        });
        //Sorting
        hospitalRecords.values().stream().sorted()
                .forEach(System.out::println);
        //Count
        System.out.println(hospitalSpecialists.stream()
                .filter(specialist -> specialist.getSalary() > 1000)
                .count());
        //Map
        List<Integer> salaries = hospitalSpecialists.stream()
                .map(specialist -> specialist.getSalary()+100)
                .collect(Collectors.toList());

        Patient khrystyna = new Patient("Khrystyna", "Peresenchuk", 24, "23.11.2022");
        Patient sheldon = new Patient("Sheldon", "Cooper", 33, "24.02.2022");

        //creating disease example
        Disease disease = new AttackOfSarcasm(MethodOfTreatment.Psychotherapy);
        sheldon.toCure(disease);

        //creating specialist example
        Specialist therapist1 = new Therapist("Dr.", "House", 25,1, 5);

        //visit testing
        SpecialistService specialistService = new SpecialistService();
        specialistService.createVisit(therapist1, khrystyna, "11.12.2022");

        //testing my toString
        Record record = new Record("27.11.2022", therapist1.getFullName(), "Patient still alive...");
        System.out.println(record.toString());
        System.out.println(therapist1.toString());
         */

        /*
        //testing my equals and hashcode
        Patient patient1 = new Patient("Monika", "Belluci", 45, "9.9.1986");
        Patient patient2 = new Patient("Monika", "Belluci", 45, "9.9.1986");

        System.out.println(patient1.hashCode());
        System.out.println(patient2.hashCode());
        System.out.println(patient1.equals(patient2));
         */

        /*
        IntToDoubleFunction i = (x) -> {return Math.sin(x);};
        logger.info(i.applyAsDouble(2));

        IntToLongFunction func = a -> 1000000 * a;
        logger.info(func.applyAsLong(2));

        LongToDoubleFunction ob = a -> a / 2;
        logger.info(ob.applyAsDouble(3));

        LongToIntFunction ob1 = a -> (int)a * 100000;
        logger.info(ob1.applyAsInt(2));
         */

        /*
        //Testing of private fields
        PrivateObject privateObject = new PrivateObject("The Private Value");

        Field privateStringField = PrivateObject.class.getDeclaredField("privateString");
        privateStringField.setAccessible(true);
        String fieldValue = (String) privateStringField.get(privateObject);
        System.out.println("fieldValue = " + fieldValue);

        Method privateStringMethod = PrivateObject.class.getDeclaredMethod("getPrivateString", null);
        privateStringMethod.setAccessible(true);
        String returnValue = (String) privateStringMethod.invoke(privateObject, null);
        System.out.println("returnValue = " + returnValue);
         */


        logger.info("Main Ended");

    }
}
