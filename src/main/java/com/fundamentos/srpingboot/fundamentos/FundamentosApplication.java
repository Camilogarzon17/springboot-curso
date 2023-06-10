package com.fundamentos.srpingboot.fundamentos;

import com.fundamentos.srpingboot.fundamentos.bean.*;
import com.fundamentos.srpingboot.fundamentos.component.ComponentDependency;
import com.fundamentos.srpingboot.fundamentos.entity.User;
import com.fundamentos.srpingboot.fundamentos.pojo.UserPojo;
import com.fundamentos.srpingboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWhitProperties myBeanWhitProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement")ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWhitProperties = myBeanWhitProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		savesUserInDataBase();
		getInformationJpqlFromUSer();
	}

	private void getInformationJpqlFromUSer(){

	/*	LOGGER.info("Usuaior con el metodo findByUserName" + userRepository.findByName("Ashley").orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndShort("", Sort.by("id").descending()).stream().forEach(user -> LOGGER.info( "usuario con metodo sort" + user));

		userRepository.findByEmail("Brayant@hotmail.com").stream().forEach(user ->  LOGGER.info("usuario con Query metodo" + user));

		LOGGER.info("usuario con Query metodo findByEmailAndName " + userRepository.findByEmailAndName("camilo@hotmail.com", "Camilo").orElseThrow(()
				-> new RuntimeException("usuraio no encontrado")));

		userRepository.findByNameLike("%n%").stream().forEach(user -> LOGGER.info("usuario encontrado con findByNameLike" + user));

		userRepository.findByNameOrEmail("Ashley", null).stream().forEach(user -> LOGGER.info("usuario encontrado con findByNameOrEmail" + user)); */

		userRepository.findByBirthDateBetween(LocalDate.of(2020,3, 19), LocalDate.of(2022, 12, 17))
				.stream()
				.forEach(user -> LOGGER.info("usuario con interbalo de fechas" + user));

		/*userRepository.findByNameLikeOrderByIdDesc("%n%").stream().forEach(user -> LOGGER.info("usuario ordenado de manera descendente con findByNameLikeOrderByIdDesc" + user));*/

		userRepository.findByNameContainingOrderByIdDesc("Camilo").stream().forEach(user -> LOGGER.info("usuario ordenado de manera descendente con findByNameLikeOrderByIdDesc" + user));

		LOGGER.info("el usuario a partir del named parameres es:" + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2023, 12, 17), "camilo@hotmail.com" )
				.orElseThrow(()-> new RuntimeException("No se encontro un usario a partir del named parameter")));
	}

	private void savesUserInDataBase(){
		User user1 = new User("Camilo", "camilo@hotmail.com", LocalDate.of(2023, 12, 17));
		User user2 = new User("Camilo", "Brayant@hotmail.com", LocalDate.of(2023, 11, 5));
		User user3 = new User("Ashley", "Ashley@hotmail.com", LocalDate.of(2023, 10, 16));
		User user4 = new User("Yulain", "Yulain@hotmail.com", LocalDate.of(2023, 9, 17));
		User user5 = new User("Jorge", "Jorge@hotmail.com", LocalDate.of(2023, 8, 1));
		User user6 = new User("Enrique", "Enrique@hotmail.com", LocalDate.of(2023, 7, 5));
		User user7 = new User("Tatiana", "Tatiana@hotmail.com", LocalDate.of(2023, 6, 7));
		User user8 = new User("Marlin", "Marlin@hotmail.com", LocalDate.of(2023, 5, 16));
		User user9 = new User("Anderson", "Anderson@hotmail.com", LocalDate.of(2022, 4, 26));
		User user10 = new User("Andres", "Andres@hotmail.com", LocalDate.of(2020, 3, 19));
		List<User> list= Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){//dependencia utilizada dentro de otro objeto
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWhitProperties.function());;
		System.out.println(userPojo.getEmail() +"-" + userPojo.getPassword() +"-"+ userPojo.getAge());
		try{
			//error
			int value = 10 / 0;
			LOGGER.debug("my value " + value);
		}catch (Exception e){
			LOGGER.error("This error aplication the division whit 0"+ e.getMessage());
		}
	}
}
