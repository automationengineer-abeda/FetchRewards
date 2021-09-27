/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *
 * @author Abeda Siddiqui
 */
public class FetchRewardsTest {

	public FetchRewardsTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}

	@Test
	public void fetchrewards() throws Exception{

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/"); 
		driver.findElement(By.id("left_0")).sendKeys("0");
		driver.findElement(By.id("left_1")).sendKeys("1");
		driver.findElement(By.id("left_2")).sendKeys("2");
		driver.findElement(By.id("left_3")).sendKeys("3");
		driver.findElement(By.id("right_0")).sendKeys("4");
		driver.findElement(By.id("right_1")).sendKeys("5");
		driver.findElement(By.id("right_2")).sendKeys("6");
		driver.findElement(By.id("right_3")).sendKeys("7");
		driver.findElement(By.id("weigh")).click();  
		Thread.sleep(2000);
		String first =driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[1]")).getText();
		System.out.println(first);

		switch(first){
		case "[0,1,2,3] = [4,5,6,7]":
			driver.findElement(By.id("coin_8")).click();
			Alert alert = driver.switchTo().alert();
			String alertMessage= driver.switchTo().alert().getText();                  
			assertEquals("Yay! You find it!", alertMessage);
			System.out.println("alertmessage its #8:" + alertMessage);
			Thread.sleep(1000);
			alert.accept();
			break;

		case "[0,1,2,3] > [4,5,6,7]":
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/button[1]")).click();
			driver.findElement(By.id("left_0")).sendKeys("4");
			driver.findElement(By.id("left_1")).sendKeys("5");
			driver.findElement(By.id("right_0")).sendKeys("6");
			driver.findElement(By.id("right_1")).sendKeys("7");
			driver.findElement(By.id("weigh")).click();
			Thread.sleep(2000);
			String second= driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[2]")).getText();
			System.out.println(second);
			if (second.equals("[4,5] > [6,7]")){                        
				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/button[1]")).click();
				driver.findElement(By.id("left_0")).sendKeys("6");
				driver.findElement(By.id("right_0")).sendKeys("7");
				driver.findElement(By.id("weigh")).click(); 
				Thread.sleep(2000);
				String third= driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[3]")).getText();
				System.out.println(third);
				if (third.equals("[6] < [7]")){
					driver.findElement(By.id("coin_6")).click();
					Alert alert1 = driver.switchTo().alert();
					String alertMessage1= driver.switchTo().alert().getText();                        
					assertEquals("Yay! You find it!", alertMessage1);
					System.out.println("alertmessage its #6 :" + alertMessage1);
					Thread.sleep(1000);
					alert1.accept();
				}
				else {
					driver.findElement(By.id("coin_7")).click();
					Alert alert2 = driver.switchTo().alert();
					String alertMessage2= driver.switchTo().alert().getText();                          
					assertEquals("Yay! You find it!", alertMessage2);
					System.out.println("alertmessage its #7 :" + alertMessage2);
					Thread.sleep(1000);
					alert2.accept();
				}
			}
			if (second.equals("[4,5] < [6,7]")){
				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/button[1]")).click();
				driver.findElement(By.id("left_0")).sendKeys("4");
				driver.findElement(By.id("right_0")).sendKeys("5");
				driver.findElement(By.id("weigh")).click(); 
				Thread.sleep(2000);
				String fourth= driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[3]")).getText();
				System.out.println(fourth);
				if (fourth.equals("[4] < [5]")){
					driver.findElement(By.id("coin_4")).click();
					Alert alert3 = driver.switchTo().alert();
					String alertMessage3= driver.switchTo().alert().getText();                         
					assertEquals("Yay! You find it!", alertMessage3);
					System.out.println("alertmessage its #4:" + alertMessage3);
					Thread.sleep(1000);
					alert3.accept();}                         
				else {
					driver.findElement(By.id("coin_5")).click();
					Alert alert4 = driver.switchTo().alert();
					String alertMessage4= driver.switchTo().alert().getText();                         
					assertEquals("Yay! You find it!", alertMessage4);
					System.out.println("alertmessage its #5:" + alertMessage4);
					Thread.sleep(1000);
					alert4.accept();}
			}
			break;

		case "[0,1,2,3] < [4,5,6,7]": 
			driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/button[1]")).click();
			driver.findElement(By.id("left_0")).sendKeys("0");
			driver.findElement(By.id("left_1")).sendKeys("1");
			driver.findElement(By.id("right_0")).sendKeys("2");
			driver.findElement(By.id("right_1")).sendKeys("3");
			driver.findElement(By.id("weigh")).click();
			Thread.sleep(2000);
			String fifth= driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[2]")).getText();
			System.out.println(fifth);
			if(fifth.equals("[0,1] < [2,3]")){
				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/button[1]")).click();
				driver.findElement(By.id("left_0")).sendKeys("0");
				driver.findElement(By.id("right_0")).sendKeys("1");
				driver.findElement(By.id("weigh")).click();
				Thread.sleep(2000);
				String sixth= driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[3]")).getText();
				System.out.println(sixth);
				if(sixth.equals("[0] > [1]")){
					driver.findElement(By.id("coin_1")).click();
					Alert alert5 = driver.switchTo().alert();
					String alertMessage5= driver.switchTo().alert().getText();                   
					assertEquals("Yay! You find it!", alertMessage5);
					System.out.println("alertmessage its #1:" + alertMessage5);
					Thread.sleep(1000);
					alert5.accept();}                     
				else {
					driver.findElement(By.id("coin_0")).click();
					Alert alert6 = driver.switchTo().alert();
					String alertMessage6= driver.switchTo().alert().getText();                    
					assertEquals("Yay! You find it!", alertMessage6);
					System.out.println("alertmessage its #0:" + alertMessage6);
					Thread.sleep(1000);
					alert6.accept();}
			}else{
				driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/button[1]")).click();
				driver.findElement(By.id("left_0")).sendKeys("2");
				driver.findElement(By.id("right_0")).sendKeys("3");
				driver.findElement(By.id("weigh")).click();
				Thread.sleep(2000);
				String seventh= driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/ol/li[3]")).getText();
				System.out.println(seventh);
				if(seventh.equals("[2] > [3]")){
					driver.findElement(By.id("coin_3")).click();
					Alert alert7 = driver.switchTo().alert();
					String alertMessage7= driver.switchTo().alert().getText();                   
					assertEquals("Yay! You find it!", alertMessage7);
					System.out.println("alertmessage its # 3 :" + alertMessage7);
					Thread.sleep(1000);
					alert7.accept();}                     
				else {
					driver.findElement(By.id("coin_2")).click();
					Alert alert8 = driver.switchTo().alert();
					String alertMessage8= driver.switchTo().alert().getText();
					assertEquals("Yay! You find it!", alertMessage8);
					System.out.println("alertmessage its #2:" + alertMessage8);
					Thread.sleep(1000);
					alert8.accept();}

			}
			break;

		}           

		Thread.sleep(1000);      
		driver.close();
	}
}