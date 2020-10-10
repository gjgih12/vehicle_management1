package com.gj.utils;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Utils {
	public static final String md5(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };   
		try {
			byte[] strTemp = str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length; 
			char ch[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];   
			    ch[k++] = hexDigits[byte0 >>> 4 & 0xf];   
			    ch[k++] = hexDigits[byte0 & 0xf];
		    }
			return new String(ch);
		} catch (NoSuchAlgorithmException e) {   
			return null;   
		}   
	}
	
	public static String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
	
	public static String genUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static byte[] byteStrToByteArr(String byteStr) {
		if (StringUtils.isEmpty(byteStr)) {
			return null;
		}
		
		byte[] pbBytes = new byte[byteStr.length()/2];
		int j = 0;
		for (int i = 0; i < byteStr.length() && i+1 < byteStr.length(); i+=2) {
			char ch1 = byteStr.charAt(i);
			char ch2 = byteStr.charAt(i+1);
			int a = 0, b = 0;
			if (ch1 >= '0' && ch1 <= '9') {
				a = ch1 - '0';
			} else if (ch1 >= 'a' && ch1 <= 'f') {
				a = 10 + ch1 - 'a';
			}
			if (ch2 >= '0' && ch2 <= '9') {
				b = ch2 - '0';
			} else if (ch2 >= 'a' && ch2 <= 'f') {
				b = 10 + ch2 - 'a';
			}
			byte tmpByte = (byte)(((a & 0x0f) << 4) + (b & 0x0f));
			pbBytes[j++] = tmpByte;
		}
		
		return pbBytes;
	}
	
	public static String bytesToHexString(byte[] src) {
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
	
	public static final String privateKey() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("classpath:conf/private_key.pem"));
			String s = br.readLine();
			String str = "";
			s = br.readLine();
			while (s.charAt(0) != '-'){
				str += s + "\r";
				s = br.readLine();
			}
			
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte[] b = base64decoder.decodeBuffer(str);

			//生成私匙
//			KeyFactory kf = KeyFactory.getInstance("RSA");
//			//X509EncodedKeySpec keySpec = new X509EncodedKeySpec(b);
//			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(b);
//			//PublicKey privateKey = kf.generatePublic(keySpec);
//			PrivateKey privateKey = kf.generatePrivate(keySpec);
			return new String(b);
//			return privateKey;
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
		
	}
	
//	public static void main(String[] args) {
//		String cp = "ios", cv = "1.0.0", cd = "asdf";
//		String cs = sha1(cp+cv+cd+Constants.PUBLIC_KEY);
//		System.out.println("cs:" + cs);
//	}
//	
//	public static final String getUid(String cp, String cd) {
//		return "u" + md5(cp+cd+Constants.PUBLIC_KEY).substring(2, 17);
//	}
//	
//	public static final String generateToken(String cp, String cv, String cd, String user) {
//		BASE64Encoder base64Encoder = new BASE64Encoder();
//		String userBase64 = base64Encoder.encode(user.getBytes());
//		String md5 = md5(cp+cv+cd+userBase64+Constants.PUBLIC_KEY+DateTimeUtil.timestamp());
//		if (md5 == null) {
//			return null;
//		}
//		
//		return md5.substring(5, 5+18);
//	}
//	
//	public static final String toString(Object obj) {
//		ObjectMapper mapper = new ObjectMapper();
//		String objStr = null;
//		try {
//			objStr = mapper.writeValueAsString(obj);
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return objStr;
//	}
//	
//	public static final <T> T toObject(String string, Class<T> clazz) {
//		ObjectMapper mapper = new ObjectMapper();
//		T object = null;
//		try {
//			object = mapper.readValue(string, clazz);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return object;
//	}
//	
//	public static final <T> List<T> toList(String string, Class<T> clazz) {
//		ObjectMapper mapper = new ObjectMapper();
//		List<T> object = null;
//		try {
//			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
//			object = mapper.readValue(string, javaType);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return object;
//	}
//	
//	public static final Map<String, Object> objectToMap(Object obj) {    
//        if (obj == null) {    
//            return null;    
//        }   
//   
//        try {
//	        Map<String, Object> map = new HashMap<String, Object>();    
//	   
//	        Field[] declaredFields = obj.getClass().getDeclaredFields();    
//	        for (Field field : declaredFields) {    
//	            field.setAccessible(true);  
//	            map.put(field.getName(), field.get(obj));  
//	        }
//	        
//	        return map;
//        } catch (Exception e) {
//        	return null;
//        }
//    }

	public static final Double distance(double long1, double lat1, double long2,  double lat2){
		double a, b, R;  
	    R = 6371000; // 地球半径  
	    lat1 = lat1 * Math.PI / 180.0;  
	    lat2 = lat2 * Math.PI / 180.0;  
	    a = lat1 - lat2;  
	    b = (long1 - long2) * Math.PI / 180.0;  
	    double d;  
	    double sa2, sb2;  
	    sa2 = Math.sin(a / 2.0);  
	    sb2 = Math.sin(b / 2.0);  
	    d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));  
	    return d;  
	}
	
	public static final Integer roundUp(double d) {
		return new BigDecimal(Double.toString(d)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
	}
	
}