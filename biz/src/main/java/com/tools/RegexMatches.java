package com.tools;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式提取数据
 * 
 * @author jin wei
 *
 */
public class RegexMatches {

	static Random r = new Random();

	public static ArrayList<String> find(String inputString, String regex) {
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(inputString);
		ArrayList<String> res = new ArrayList<String>();
		while (matcher.find()) {
			int i = 0;
			res.add(matcher.group(++i));
		}
		return res;
	}

	public static String findByRamdom(String inputString, String regex) {
		ArrayList<String> res = RegexMatches.find(inputString, regex);
		int length = res.size();
		return res.get(r.nextInt(length));
	}

	public static String findByNum(String inputString, String regex, int num) {
		ArrayList<String> res = RegexMatches.find(inputString, regex);
		int length = res.size();
		return (num <= length) ? res.get(num) : res.get(length - 1);
	}

	public static String findDefault(String inputString, String regex) {
		ArrayList<String> res = RegexMatches.find(inputString, regex);
		return res.get(0);
	}

	public static ArrayList<String> findAll(String inputString, String regex) {
		return RegexMatches.find(inputString, regex);
	}
}
