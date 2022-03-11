package com.crm.ty;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {
	/**
	 * This mehod is going to generate random number.
	 * @return random number till 1000
	 */
	public int  generateRandomNumber() 
	{
		Random random=new Random();
		return random.nextInt(1000);
	}
	/**
	 * This method is going to generate Fake Address
	 * @returnfake address
	 */

	public String fakefirstName() 
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	/**
	 * This method is going to generate Fake Address
	 * @return fake address
	 */
	public String fakelastName()
	{
		Faker faker=new Faker();
		return faker.name().lastName();
	}
	/**
	 *This method is going to generate Fake Company Name
	 *@return fake company name
	 */
	public String fakeCompanyName()
	{
	Faker faker=new Faker();
	return faker.company().name();
	}
}
