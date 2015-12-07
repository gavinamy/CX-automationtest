package com.cx.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

//import com.test.util.Log;

public class RandomUtilNew {	
	/**
	 * 返回一个0-count（包含count）的随机数
	 * @param count
	 * @return
	 * @author WEIBAIXIN547
	 */
	public int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

	/**
	 * 返回一个随机的手机号
	 * @param count
	 * @return
	 */

    public  String  getRandomPhoneNumber(String firstThree) {
    	//return firstThree +String.valueOf(Math.round(Math.round(8)));
    	String sf ="11111111";
    	//ddhhmmss
    	try {
    		sf = new SimpleDateFormat("ddHHmmss").format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
		}
   	    return firstThree + sf; 
       }
    	   
	/**
	 * 返回当前时间
	 * @param count
	 * @return
	 */

    public  String  getCurrentTime() {
    	//return firstThree +String.valueOf(Math.round(Math.round(8)));
    	String sf ="11111111";
    	//ddhhmmss
    	try {
    		sf = new SimpleDateFormat("ddHHmmss").format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
		}
   	    return  sf; 
       }
    	   
	
	/**
	 * 从0123456789abcdefghijklmnopqrstuvwxyz中选随机生成长度为length的字符串
	 * @param length
	 * @return
	 */
private String string ="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终";
	
	/**
	 * 从0123456789abcdefghijklmnopqrstuvwxyz中选随机生成长度为length的字符串
	 * @param length
	 * @return
	 */
			
	public String getRandomString(int length){
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(this.getRandom(len-1)));
		}
		return sb.toString();
	}
	
	

	/**
	 *
	 * @param length
	 * @return
	 */		
    public  String  getRandomUser(String firstFour) {
    	//return firstThree +String.valueOf(Math.round(Math.round(8)));
    	String sf ="11111111";
    	//ddhhmmss
    	try {
    		sf = new SimpleDateFormat("ddHHmmss").format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
		}
   	    return firstFour + sf; 
       }
		
		public static void main(String[] args) {
			RandomUtilNew ru = new RandomUtilNew();
			for (int i = 0; i < 10; i++) {
//				Log.logInfo(ru.getRandomString(6));
			}
			
		}	
	}

