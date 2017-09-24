import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaperWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaperWorld extends World
{
    private boolean valid = true; //If the passport documents are valid
    private String firstName; //First name on the document, generated
    private String lastName; //Last name on the document, generated
    private String expirationDate; //Expiration date on the document, generated
    private String birthDate; //Birth date on the document, generated
    private String issueDate; //Issue date on the document, generated
    private int country; //Country on the document, generated
    private String gender; //Gender on the document, generated
    private int image; //Image on the document, generated
    private boolean spawn = true;
    private String[] dictionaryLastName = {"SMITH", "JOHNSON", "WILLIAMS", "BROWN", "JONES", "MILLER", "DAVIS", "GARCIA", "RODRIGUEZ", "WILSON", "MARTINEZ", "ANDERSON", "TAYLOR", "THOMAS", "HERNANDEZ", "MOORE", "MARTIN", "JACKSON", "THOMPSON", "WHITE", "LOPEZ", "LEE", "GONZALEZ", "HARRIS", "CLARK", "LEWIS", "ROBINSON", "WALKER", "PEREZ", "HALL", "YOUNG", "ALLEN", "SANCHEZ", "WRIGHT", "KING", "SCOTT", "GREEN", "BAKER", "ADAMS", "NELSON", "HILL", "RAMIREZ", "CAMPBELL", "MITCHELL", "ROBERTS", "CARTER", "PHILLIPS", "EVANS", "TURNER", "TORRES", "PARKER", "COLLINS", "EDWARDS", "STEWART", "FLORES", "MORRIS", "NGUYEN", "MURPHY", "RIVERA", "COOK", "ROGERS", "MORGAN", "PETERSON", "COOPER", "REED", "BAILEY", "BELL", "GOMEZ", "KELLY", "HOWARD", "WARD", "COX", "DIAZ", "RICHARDSON", "WOOD", "WATSON", "BROOKS", "BENNETT", "GRAY", "JAMES", "REYES", "CRUZ", "HUGHES", "PRICE", "MYERS", "LONG", "SANDERS", "ROSS", "MORALES", "POWELL", "SULLIVAN", "RUSSELL", "ORTIZ", "JENKINS", "GUTIERREZ", "PERRY", "BUTLER", "BARNES", "FISHER", "HENDERSON", "COLEMAN", "SIMMONS", "PATTERSON", "JORDAN", "REYNOLDS", "HAMILTON", "GRAHAM", "KIM", "GONZALES", "ALEXANDER", "RAMOS", "WALLACE", "GRIFFIN", "WEST", "COLE", "HAYES", "CHAVEZ", "GIBSON", "BRYANT", "ELLIS", "STEVENS", "MURRAY", "FORD", "MARSHALL", "OWENS", "MCDONALD", "HARRISON", "RUIZ", "KENNEDY", "WELLS", "ALVAREZ", "WOODS", "MENDOZA", "CASTILLO", "OLSON", "WEBB", "WASHINGTON", "TUCKER", "FREEMAN", "BURNS", "HENRY", "VASQUEZ", "SNYDER", "SIMPSON", "CRAWFORD", "JIMENEZ", "PORTER", "MASON", "SHAW", "GORDON", "WAGNER", "HUNTER", "ROMERO", "HICKS", "DIXON", "HUNT", "PALMER", "ROBERTSON", "BLACK", "HOLMES", "STONE", "MEYER", "BOYD", "MILLS", "WARREN", "FOX", "ROSE", "RICE", "MORENO", "SCHMIDT", "PATEL", "FERGUSON", "NICHOLS", "HERRERA", "MEDINA", "RYAN", "FERNANDEZ", "WEAVER", "DANIELS", "STEPHENS", "GARDNER", "PAYNE", "KELLEY", "DUNN", "PIERCE", "ARNOLD", "TRAN", "SPENCER", "PETERS", "HAWKINS", "GRANT", "HANSEN", "CASTRO", "HOFFMAN", "HART", "ELLIOTT", "CUNNINGHAM", "KNIGHT", "BRADLEY"};
    private String[] dictionaryMaleFirstName = {"Jackson", "Aiden", "Liam", "Lucas", "Noah", "Mason", "Jayden", "Ethan", "Jacob", "Jack", "Caden", "Logan", "Benjamin", "Michael", "Caleb", "Ryan", "Alexander", "Elijah", "James", "William", "Oliver", "Connor", "Matthew", "Daniel", "Luke", "Brayden", "Jayce", "Henry", "Carter", "Dylan", "Gabriel", "Joshua", "Nicholas", "Isaac", "Owen", "Nathan", "Grayson", "Eli", "Landon", "Andrew", "Max", "Samuel", "Gavin", "Wyatt", "Christian", "Hunter", "Cameron", "Evan", "Charlie", "David", "Sebastian", "Joseph", "Dominic", "Anthony", "Colton", "John", "Tyler", "Zachary", "Thomas", "Julian", "Levi", "Adam", "Isaiah", "Alex", "Aaron", "Parker", "Cooper", "Miles", "Chase", "Muhammad", "Christopher", "Blake", "Austin", "Jordan", "Leo", "Jonathan", "Adrian", "Colin", "Hudson", "Ian", "Xavier", "Camden", "Tristan", "Carson", "Jason", "Nolan", "Riley", "Lincoln", "Brody", "Bentley", "Nathaniel", "Josiah", "Declan", "Jake", "Asher", "Jeremiah", "Cole", "Mateo", "Micah", "Elliot"};
    private String[] dictionaryFemaleFirstName = {"Sophie", "Emma", "Olivia", "Isabella", "Mia", "Ava", "Lily", "Zoe", "Emily", "Chloe", "Layla", "Madison", "Madelyn", "Abigail", "Aubrey", "Charlotte", "Amelia", "Ella", "Kaylee", "Avery", "Aaliyah", "Hailey", "Hannah", "Addison", "Riley", "Harper", "Aria", "Arianna", "Mackenzie", "Lila", "Evelyn", "Adalyn", "Grace", "Brooklyn", "Ellie", "Anna", "Kaitlyn", "Isabelle", "Sophie", "Scarlett", "Natalie", "Leah", "Sarah", "Nora", "Mila", "Elizabeth", "Lillian", "Kylie", "Audrey", "Lucy", "Maya", "Annabelle", "Makayla", "Gabriella", "Elena", "Victoria", "Claire", "Savannah", "Peyton", "Maria", "Alaina", "Kennedy", "Stella", "Liliana", "Allison", "Samantha", "Keira", "Alyssa", "Reagan", "Molly", "Alexandra", "Violet", "Charlie", "Julia", "Sadie", "Ruby", "Eva", "Alice", "Eliana", "Taylor", "Callie", "Penelope", "Camilla", "Bailey", "Kaelyn", "Alexis", "Kayla", "Katherine", "Sydney", "Lauren", "Jasmine", "London", "Bella", "Adeline", "Caroline", "Vivian", "Juliana", "Gianna", "Skyler", "Jordyn"};
    private String[] dictionaryCountry = {"Norway", "Finland", "Estonia", "Latvia", "Lithuania", "Poland", "Belarus", "Ukraine", "Georgia", "Azerbaijan", "Kazakhstan", "China", "Mongolia"};

    /**
     * Constructor for objects of class PaperWorld.
     * 
     */
    public PaperWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 

        addObject(new Header(), 500,50);
        addObject(new DocumentTray(), 705, 350);
        addObject(new Sidebar(), 205, 351);
        addObject(new Stamps(), 698,35);
        addObject(new Instructions(), 698,351);
        addObject(new HealthBar(),40,550);
        addObject(new FingerprintRecord(), 698,600);
        addObject(new FingerprintReal(), 698,500);
        addObject(new Sound("paperWorld"), 0, 0);
        setPaintOrder(Header.class,FingerprintRecord.class, Stamps.class);
        if(spawn)
            newDocuments();
        spawn = false;
    }

    public void newDocuments() //Creates new documents
    {
        int expiryDD = Greenfoot.getRandomNumber(30) + 1; //Generates a random date for the expiry between 1 and 30
        int expiryMM = Greenfoot.getRandomNumber(11) + 2; //Generates a random month for the expiry between 2 and 12, game takes place in January, so it prevents confusion
        int expiryYYYY = Greenfoot.getRandomNumber(10) + 1984; //Generates a random year between 1984 and 1993
        expirationDate = expiryDD + "/" + expiryMM + "/" + expiryYYYY; //Appends the date, month and year together to create a string

        int birthDD = Greenfoot.getRandomNumber(30) + 1; //Generates a random date for the birth date between 1 and 30
        int birthMM = Greenfoot.getRandomNumber(12) + 1; //Generates a random month for the birth date between 1 and 12
        int birthYYYY = 1984 - Greenfoot.getRandomNumber(80) - 19; //Generates a random year for the birth date, between 1886 and 1965
        birthDate = birthDD + "/" + birthMM + "/" + birthYYYY; //Appends the date, month and year together to create a string

        int issueDD = expiryDD; //Sets the issue date to be the same as the expiry date
        int issueMM = expiryMM; //Sets the issue month to be the same as the expiry month
        int issueYYYY = expiryYYYY - 10; //Sets the issue year to be 10 years before the expiry year
        issueDate = issueDD + "/" + issueMM + "/" + issueYYYY; //Appends the date, month and year together to create a string

        lastName = dictionaryLastName[Greenfoot.getRandomNumber(199)]; //Finds a last name to use from the dictionary
        country = Greenfoot.getRandomNumber(14); //Finds a country to use from the dictionary

        if(Greenfoot.getRandomNumber(2) == 1) //50% chance of female, vice-versa
        {
            gender = "female"; //Set gender to be female
            firstName = dictionaryFemaleFirstName[Greenfoot.getRandomNumber(100)]; //Find a first name out of 100
            image = Greenfoot.getRandomNumber(13); //Set a random image
        }
        else {
            gender = "male"; //Set gender to be male
            firstName = dictionaryMaleFirstName[Greenfoot.getRandomNumber(100)]; //Find a first name out of 100
            image = Greenfoot.getRandomNumber(14); //Set a random image
        }

        //Choose whether it is valid or not first
        int r = Greenfoot.getRandomNumber(1000); //Random number between 0 and 999

        if(r == 0) //Sets the document to be chris cao, 0.1% chance
        {
            //Permission to use this name was granted
            firstName = "Chris";
            lastName = "CAO";
            gender = "male";
            birthDate = "04/20/1962";
            issueDate = "03/02/1983";
            expirationDate = "03/02/1993";
            country = 11;
            image = 1;
            valid = false;
        }

        if(r == 1) //Sets the document to be luke cilia, 0.1% chance
        {
            //Permission to use this name was granted
            firstName = "Luke";
            lastName = "CILIA";
            gender = "male";
            birthDate = "06/09/1962";
            issueDate = "03/02/1983";
            expirationDate = "03/02/1993";
            country = 3;
            image = 2;
            valid = false;
        }

        if(r == 2) //Sets the document to be dylan foster, 0.1% chance
        {
            //Permission to use this name was granted
            firstName = "Dylan";
            lastName = "FOSTER";
            gender = "male";
            birthDate = "03/06/1962";
            issueDate = "03/02/1983";
            expirationDate = "03/02/1993";
            country = 2;
            image = 3;
            valid = false;
        }

        if(r >= 3 && r < 150) //Sets the document to have an invalid expiry, 14.7% chance
        {
            expiryDD = Greenfoot.getRandomNumber(30) + 1;
            expiryMM = Greenfoot.getRandomNumber(11) + 2;
            expiryYYYY = 1983 - Greenfoot.getRandomNumber(10);
            expirationDate = expiryDD + "/" + expiryMM + "/" + expiryYYYY;
            valid = false;
        }

        if(r >= 150 && r < 250) //Sets the document to have an invalid birtdate, 10% chance
        {
            birthDD = Greenfoot.getRandomNumber(30) + 1;
            birthMM = Greenfoot.getRandomNumber(12) + 1;
            birthYYYY = 1984 - Greenfoot.getRandomNumber(18);
            birthDate = birthDD + "/" + birthMM + "/" + birthYYYY;
            valid = false;
        }

        if(r >= 250 && r < 350) //Sets the document to have an invalid issue date, 10% chance
        {
            issueDD = expiryDD;
            issueMM = expiryMM;
            issueYYYY = expiryYYYY - Greenfoot.getRandomNumber(10);
            issueDate = issueDD + "/" + issueMM + "/" + issueYYYY;
            valid = false;
        }

        if(r >= 350 && r < 450) //Sets the document to have an invalid gender, 10% chance
        {
            if(gender == "male")
                gender = "female";
            if(gender == "female")
                gender = "male";
            valid = false;
        }

        if(r >= 450 && r < 500) //Sets the document to be from North Korea, 5% chance
        {
            country = 10;
            valid = false;
        }

        //         if(r < 500) //If the document is invalid
        //         {
        //             valid = false; //Set validity to false
        //         }
        //         else {
        //             valid = true; //Set validity to true
        //         }

        //debug
        System.out.println(r + "," + valid + "," + firstName + "," + lastName + "," + expirationDate + "," + birthDate + "," + country + "," + gender + "," + issueDate + "," + image);
        //Adds the object to the world
        addObject(new Passport(valid, firstName, lastName, expirationDate, birthDate, country, gender, issueDate, image), 684, 295);
    }
}
