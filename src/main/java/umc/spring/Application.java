package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.*;
import umc.spring.service.StoreService.StoreQueryService;


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
			MemberQueryService memberService = context.getBean(MemberQueryService.class);
			DoMissionQueryService doMissionService = context.getBean(DoMissionQueryService.class);
			MissionQueryService missionService = context.getBean(MissionQueryService.class);
			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);

			String name = "요아정";
			Float rating = 4.0f;


			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + rating);

			storeService.findStoresByNameAndScore(name, rating)
					.forEach(System.out::println);



			Long userId = 2L;
			MissionStatus missionStatus = MissionStatus.PROGRESS;

			System.out.println("Executing findProgressMission with parameters:");
			System.out.println("MemberId: " + userId);
			System.out.println("Progress: " + missionStatus);

			doMissionService.findDoMissionBymember(userId, missionStatus)
					.forEach(System.out::println);

			missionStatus = MissionStatus.COMPLETE;
			System.out.println("Executing findProgressMission with parameters:");
			System.out.println("MemberId: " + userId);
			System.out.println("Progress: " + missionStatus);

			doMissionService.findDoMissionBymember(userId, missionStatus)
					.forEach(System.out::println);

			memberService.findMemberWithId(userId)
					.forEach(System.out::println);

			Long regionId =1L;

			System.out.println("Executing findMission with parameters:");
			System.out.println("MemberId: " + userId);
			System.out.println("regionId: " + regionId);
			missionService.findMissionByregion(regionId, userId)
					.forEach(System.out::println);

			Long count = missionService.getMissionCount(regionId, userId);
			System.out.println("Count: " + count);



			Long storeId = 1L;
			String content = "메에에ㅔ에에에에ㅔ에에에에ㅔ에에";
			Float score = 5.0f;
			userId = 1L;



			System.out.println("User ID: " + userId);
			System.out.println("Store ID: " + storeId);
			System.out.println("Title: " + content);
			System.out.println("Score: " + score);


			reviewService.createReview(userId, storeId, score, content);


		};




}}
