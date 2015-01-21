package org.brometheus.passwordgenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Kalle on 21.1.2015.
 */
public class PasswordGenerator {


    private int length;
    private char type; // case-sensitive letters; numbers; special characters
                        // .-!?,;:_"#¤%&/()='*
                      //SNC   -    00000-SPECIAL-NUMBER-CASESENSITIVE
                        // type is between 0 to 7, three last bits of char
    private String password;
    ArrayList<Character> characters;


    public PasswordGenerator(char type, int length)
    {
        this.length=length;
        this.type=type;
        this.password=new String();
        this.characters= new ArrayList<Character>();
        addLowercase();
        //if uppercase allowed - 1 = 1
        if ((type&1)>0)
            addUpperCase();
        //if numbers allowed - 2=2
        if ((type&2)>0)
            addNumbers();
        //if special characters are allowed
        if ((type&4)>0)
            addSpecial();

    }
    //if no info is given, make 8 letters, only lowercase letters
    public PasswordGenerator()
    {
        this.length=8;
        this.type=0;  // type = 00000000 - no numbers, no special characters, lowercase only.
        this.characters=new ArrayList<Character>();
        addLowercase();
    }



    public String generatePassword()
    {

        for (int i = 0;i<length;i++) {
            SecureRandom random = new SecureRandom();
            password=password+characters.get((int)(Math.floor(random.
                    nextDouble()* (double) characters.size())));
        }

        return password;
    }

    private int addLowercase()
    {
        for (int i=0;i<25;i++)
        {
            characters.add((char)(97+i));
        }
     return 1;
    }
    private int addUpperCase()
    {
        for (int i=0;i<25;i++)
        {
            characters.add((char)(65+i));
        }
        return 1;
    }
    private int addNumbers()
    {
        for (int i=0;i<10;i++)
        {
            characters.add((char)(48+i));
        }
        return 1;
    }

    //not available yet
    private int addSpecial()
    {
        return 1;
    }



}
