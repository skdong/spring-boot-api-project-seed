package com.company.project.convert;

public class HexConvert {

	public static String  convertStringToHex(String str){
		 
	    char[] chars = str.toCharArray();
	 
	    StringBuffer hex = new StringBuffer();
	    for(int i = 0; i < chars.length; i++){
	        hex.append(Integer.toHexString((int)chars[i]));
	    }
	 
	    return hex.toString();
	}
	public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder(""); 
		    if (src == null || src.length <= 0) {   
		        return null;   
		    }   
		    for (int i = 0; i < src.length; i++) {   
		        int v = src[i] & 0xFF;   
		        String hv = Integer.toHexString(v);   
		        if (hv.length() < 2) {   
		            stringBuilder.append(0);   
		        }   
		        stringBuilder.append(hv);   
		    }   
		    return stringBuilder.toString();   
		}   
	 
	public static String convertHexToString(String hex){
	 
	    StringBuilder sb = new StringBuilder();
	    StringBuilder sb2 = new StringBuilder();
	 
	    for( int i=0; i<hex.length()-1; i+=2 ){
	 
	        String s = hex.substring(i, (i + 2));           
	        int decimal = Integer.parseInt(s, 16);          
	        sb.append((char)decimal);
	        sb2.append(decimal);
	    }
	 
	    return sb.toString();
	}
	public static byte[] hexStringToBytes(String hexString) {
	    if (hexString == null || hexString.equals("")) {
	        return null;
	    }
	    // toUpperCase将字符串中的所有字符转换为大写
	    hexString = hexString.toUpperCase();
	    int length = hexString.length() / 2;
	    // toCharArray将此字符串转换为一个新的字符数组。
	    char[] hexChars = hexString.toCharArray();
	    byte[] d = new byte[length];
	    for (int i = 0; i < length; i++) {
	        int pos = i * 2;
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
	    }
	    return d;
	}
	//返回匹配字符
	private static byte charToByte(char c) {
	    return (byte) "0123456789ABCDEF".indexOf(c);
	}
	 
	//将字节数组转换为short类型，即统计字符串长度
	public static short bytes2Short2(byte[] b) {
	    short i = (short) (((b[1] & 0xff) << 8) | b[0] & 0xff);
	    return i;
	}
	//将字节数组转换为16进制字符串
	public static String BinaryToHexString(byte[] bytes) {
	    String hexStr = "0123456789ABCDEF";
	    String result = "";
	    String hex = "";
	    for (byte b : bytes) {
	        hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
	        hex += String.valueOf(hexStr.charAt(b & 0x0F));
	        result += hex + " ";
	    }
	    return result;
	}
	 
	public static void main(String[] args) {
	 
	 
	    System.out.println("======ASCII码转换为16进制======");
	    String str = "*00007VERSION\\n1$";
	    System.out.println("字符串: " + str);
	    String hex = "4C 4F 4F EC 00 9A 05 7E 75 46 02 49 18 02 04 02 F6 00 FF FF FF FF FF FF FF FF FF FF FF FF FF FF FF 62 FF FF FF FF FF FF FF 00 00 FF 28 00 44 00 12 CB 43 00 FF 01 BE 12 02 00 31 00 EC 0C FF FF FF FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 2B 03 06 2C 8B 02 A7 06 0A 0D EA 26";//HexConvert.convertStringToHex(str);
	    hex = hex.replace(" ", "");
	    System.out.println("====转换为16进制=====" + hex);
	 
	    System.out.println("======16进制转换为ASCII======"+hex.length());
	    System.out.println("Hex : " + hex);
	    String hex1 ="4C 4F 4F EC 00 9A 05 7E 75 46 02 49 18 02 04 02 F6 00 FF FF FF FF FF FF FF FF FF FF FF FF FF FF FF 62 FF FF FF FF FF FF FF 00 00 FF 28 00 44 00 12 CB 43 00 FF 01 BE 12 02 00 31 00 EC 0C FF FF FF FF FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 2B 03 06 2C 8B 02 A7 06 0A 0D EA 26";//HexConvert.convertStringToHex(str);
	    System.out.println("ASCII : " + HexConvert.convertHexToString(hex));
	 
	    byte[] bytes = HexConvert.hexStringToBytes( hex );
	    System.out.println("bytes lenght : " + bytes.length);
	    System.out.println(HexConvert.BinaryToHexString( bytes ));
	}
	
}
