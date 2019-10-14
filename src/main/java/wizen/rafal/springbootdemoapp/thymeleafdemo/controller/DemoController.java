package wizen.rafal.springbootdemoapp.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wizen.rafal.springbootdemoapp.thymeleafdemo.gamecomponents.GameTable;

@Controller
public class DemoController {

	private GameTable gameTable;
	


	// create mapping for "/hello" - TESTS
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
	}
	
	// method to return start-page
	@GetMapping("/start-page")
	public String startPage() {
		
		return "start-page";
	}
	
	//
	@RequestMapping("/newGame")
	public String newGame(@RequestParam("test") String test, Model theModel) {
		
		System.out.println(test);
		gameTable = new GameTable();
		theModel.addAttribute("gameTable", gameTable);
		
		return "game-table";
	}
	
	@GetMapping("/hit")
	public String hit(Model theModel) {
		gameTable.playerGetsCard();
		if(gameTable.checkforPlayersLoose()) {
		theModel.addAttribute("gameTable", gameTable);
		return "end-of-game";
		}
		theModel.addAttribute("gameTable", gameTable);
		return "game-table";
	}
	
	@GetMapping("/stand")
	public String stand(Model theModel) {
		gameTable.croupierStartsHisTurn();
		
		theModel.addAttribute("gameTable", gameTable);
		
		return "end-of-game";
	}
	
	@GetMapping("/bet")
	public String bet(Model theModel) {
		theModel.addAttribute("gameTable", gameTable);
		
		return "bet";
	}
}
