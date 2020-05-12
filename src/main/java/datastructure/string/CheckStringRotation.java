package string;

import org.apache.commons.lang3.StringUtils;

public class CheckStringRotation {

    /**
     * Check is the one string is roteted by the n characters
     *
     * @param orgString
     * @param rotatedString
     * @param rotation
     * @return
     */
    public static boolean isStringRotated(String orgString,String rotatedString,int rotation){
        StringBuilder builder = new StringBuilder();
        if(StringUtils.isEmpty(orgString) || StringUtils.isEmpty(rotatedString) || orgString.length()!= rotatedString.length()){
            return false;
        }else{
            builder.append(orgString.substring(rotation,orgString.length()));
            builder.append(orgString.substring(0, rotation));
            //This for loop in nor required, we can use string sub string method to append the rotation part
//            for(int i=0;i<rotation;i++){
//                builder.append(orgString.charAt(i));
//            }
        }
        return rotatedString.equals(builder.toString());
    }

    public static void main(String[] args) {
        System.out.println(isStringRotated("amazon", "azonam",2));
        System.out.println(isStringRotated("techknowledge", "chknowledgeet",2));
        System.out.println(isStringRotated("techknowledge", "knowledgetech",4));
    }
}
