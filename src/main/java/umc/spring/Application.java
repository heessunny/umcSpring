package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.MemberQueryService;
import umc.spring.service.MissionQueryService;
import umc.spring.service.StoreQueryService;


@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);
			//MemberQueryService memberService = context.getBean(MemberQueryService.class);
			MissionQueryService missionService = context.getBean(MissionQueryService.class);

			String name = "요아정";
			Float rating = 4.0f;


			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + rating);

			storeService.findStoresByNameAndScore(name, rating)
					.forEach(System.out::println);

//			Long id = 1L;
//			memberService.findMember(id);

			Long userId = 1L;
			MissionStatus missionStatus = MissionStatus.PROGRESS;

			System.out.println("Executing findProgressMission with parameters:");
			System.out.println("MemberId: " + userId);
			System.out.println("Progress: " + missionStatus);

			missionService.findDoMissionBymember(userId, missionStatus)
					.forEach(System.out::println);

			missionStatus = MissionStatus.COMPLETE;
			System.out.println("Executing findProgressMission with parameters:");
			System.out.println("MemberId: " + userId);
			System.out.println("Progress: " + missionStatus);

			missionService.findDoMissionBymember(userId, missionStatus)
					.forEach(System.out::println);
		};
}}
