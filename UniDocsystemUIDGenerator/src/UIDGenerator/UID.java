package UIDGenerator;

public class UID {
    private void generateUID(byte versionNumber, long availableLowest, long availableHighest) {
        
        byte validationDigit;
        String UID;
       
        while(availableLowest!=availableHighest){
            
            if(isValid(availableLowest)){
               validationDigit= validationDigitOfVersionOne(convertToByteArray(availableLowest));  
               UID = composeUID(versionNumber, availableLowest, validationDigit);                   
            }    
            availableLowest++;
        }       
    }
    
    private boolean isValid(long bufferedNumber){
       
       boolean validity= true;
       byte operationalArray[] = convertToByteArray(bufferedNumber);
       byte countFrequency[] = new byte[10];
       byte i;
       
       for(i=0 ; i<countFrequency.length ; i++){
           countFrequency[i]=0;
       }
       
       for(i=0 ; i<operationalArray.length ; i++){
           countFrequency[operationalArray[i]]++; 
           if(countFrequency[operationalArray[i]]>=5){
               validity = false;       
           }
       }        
       return validity;  
    }
    
    private static byte[] convertToByteArray(long input)
    {
        byte[] convertedIntegrArray = new byte[10];
        byte counter =9;
        long temp;
        while(counter>-1){
            temp = input%10;
            convertedIntegrArray[counter] =(byte) temp;       
            input = input/10;  
            counter--;
        }
        return convertedIntegrArray;
    }
    
    private byte validationDigitOfVersionOne(byte[] bufferedNumber){
        
        byte validationDigit;
        int temp= bufferedNumber[1] + bufferedNumber[4] + bufferedNumber[7] + bufferedNumber[5];
        validationDigit = digitSum(temp);
        return validationDigit;
    }
    
    private byte digitSum(int num){
        byte sum = 0;
        while (num > 0)
        {
            sum +=(byte) num % 10;
            num /= 10;
        }
        if (sum > 9)
        {
            sum = digitSum(sum);
        }
        return sum;
    }
    
    private String composeUID(byte versionNumber, long availableNumber, byte validationDigit){
        
        String sversionNumber = Byte.toString(versionNumber);
        String savailableNumber = Long.toString(availableNumber);
        String svalidationDigit = Byte.toString(validationDigit);
        
        String tuid  = sversionNumber+savailableNumber+svalidationDigit;
        
        char suid[] = tuid.toCharArray();
        
        String UID = Character.toString(suid[5])+
                     Character.toString(suid[9])+
                     Character.toString(suid[1])+
                     Character.toString(suid[11])+
                     Character.toString(suid[6])+
                     Character.toString(suid[8])+
                     Character.toString(suid[2])+
                     Character.toString(suid[4])+
                     Character.toString(suid[0])+
                     Character.toString(suid[7])+
                     Character.toString(suid[10])+
                     Character.toString(suid[3]);
        return UID;
    }
}
