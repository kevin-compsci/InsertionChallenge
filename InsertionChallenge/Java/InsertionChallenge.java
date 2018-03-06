/*
Kevin Nguyen
Basic Java program that inserts into given string based on kth index.

How to run (linux):
	1.) open command line and cd into directory folder of where this code is
	2.) type in "javac *.java" to compile java files
	3.) type in "java InsertionChallenge"
*/

//imports
import java.io.*;
import java.util.*;

//class
class InsertionChallenge {
	//Global Declarations

	//main driver
	public static void main(String[] args) {
		//local Declarations
		String result = solution("2-4A0r7-4kt02g", 2);
		System.out.println(result);
	}

	//function definitions below
    public static String solution(String s, int k) {
    	//Local declaration
    	String upperStr = s.toUpperCase(), result = ""; //set uppercase
    	String upperStrNoDash = upperStr.replaceAll("-", ""); //remove dashes
    	int length = upperStrNoDash.length(), i = 0, tmp = 0; //get length and set i counter; extra tmp counter

    	//need to offset?
		if((length % k) != 0) {
			upperStrNoDash = "^" + upperStrNoDash;
			length++;
		}
		//call string buffer to use their insert function
		StringBuffer sb = new StringBuffer(upperStrNoDash);

    	//loop through all characters and insert dashes into string
    	while(i < length) {
    		//conditional insert into string buffer
    		if(tmp == k) {
    			sb.insert(i, "-"); //insert into ith position
    			tmp = 0; i++; length++; //reset tmp, increase ith and length to avoid iterating over the extra '-' character again
    			continue;
    		}
    		tmp++;
    		i++;
    	}

    	//get string from buffer and remove offset if any
    	result = sb.toString();
    	if(result.charAt(0) == '^') {
	    	result = result.substring(1,length);
    	}
    	return result;
    }
}