package webadv.s99201105.p02;

import java.util.*;	
import java.io.*;
import org.apache.commons.codec.digest.DigestUtils;

public class App {
    public static void main(String[] args) {
		String name="";
		String password="";
		Scanner in=new Scanner(System.in);
		System.out.println("请输入账号：");
		name=in.nextLine();
		System.out.println("请输入密码：");
		password=in.nextLine();
		boolean result1=false;
		boolean result2=false;
		String pathname = "/17204202/src/main/java/webadv/s99201105/p02/login.txt"; 
        try (FileReader reader = new FileReader(pathname);
        		BufferedReader br = new BufferedReader(reader) 
                ){
                    String lineText;
        			int line=0;
        			
                    while ((lineText = br.readLine()) != null) {
        				line++;
        				if(line==1&&lineText.equals(name))
        					result1=true;
        				if(line==2&&lineText.equals(sha256hex(password)))
        					result2=true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        		
        		if (result1&&result2) {
                    System.out.println("登录成功！");
                    System.exit(0);
                }else{
        			System.out.println("账号或密码错误！");
                    System.exit(0);
        		}
            }
        	
        	public static String sha256hex(String input) {
                return DigestUtils.sha256Hex(input);
            }
        }


