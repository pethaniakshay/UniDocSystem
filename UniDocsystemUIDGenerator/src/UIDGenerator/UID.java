package UIDGenerator;

import java.math.BigInteger;

public class UID {
    private void generateUID(int versionNumber, BigInteger availableLowest, BigInteger availableHighest) {
        
        int validationDigit;
            
        while(!availableLowest.equals(availableHighest)){
            
            if(isValid(availableLowest)){
               validationDigit= validationDigitOfVersionOne(convertToIntArray(availableLowest.toByteArray()));
               
            }    
            availableLowest = availableLowest.add(BigInteger.ONE);
        }       
    }
    
    private boolean isValid(BigInteger bufferedNumber){
       
       boolean validity= true;
       int operationalArray[] = convertToIntArray(bufferedNumber.toByteArray());
       int countFrequency[] = new int[10];
       
       for(int i=0 ; i<countFrequency.length ; i++){
           countFrequency[i]=0;
       }
       
       for(int i=0 ; i<operationalArray.length ; i++){
           countFrequency[operationalArray[i]]++; 
           if(countFrequency[operationalArray[i]]>=5){
               validity = false;       
           }
       }        
       return validity;  
    }
    
    private static int[] convertToIntArray(byte[] input)
    {
        int[] ret = new int[input.length];
        for (int i = 0; i < input.length; i++)
        {
            ret[i] = input[i]; 
        }
        return ret;
    }
    
    private int validationDigitOfVersionOne(int[] bufferedNumber){
        
        int validationDigit=0;
        int temp;
        temp = bufferedNumber[1] + bufferedNumber[4] + bufferedNumber[7] + bufferedNumber[5];
        validationDigit = digitSum(temp);
        return validationDigit;
    }
    
    private int digitSum(int num){
        int sum = 0;
        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        if (sum > 9)
        {
            sum = digitSum(sum);
        }
        return sum;
    }
    
    private String composeUID(int versionNumber, BigInteger bufferedNumber, int validationDigit){
        String UID="";
        
        return UID;
    }
}
