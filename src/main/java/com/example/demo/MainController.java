package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Summoner;

@Controller
public class MainController {
	
	
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String proyectos(HttpSession session, Model template) throws Exception {
		
		String rawData = NetworkDAO.request("https://api.npoint.io/6e9db3193b6100d79d68/");
		
		JSONObject raiz = new JSONObject(rawData);
		JSONArray jsonApi = raiz.getJSONArray("api");
		JSONArray summoners = raiz.getJSONArray("summoners");
		
		JSONObject api1 = jsonApi.getJSONObject(0);
		JSONObject api2 = jsonApi.getJSONObject(1);
		String apikey1 = api1.getString("api");
		String apikey2 = api2.getString("api");
		ArrayList<Summoner> listadoSummoners= new ArrayList<Summoner>();
		
		for(int i =0; i<summoners.length();i++) {
			JSONObject summoner = summoners.getJSONObject(i);
			String nombre = summoner.getString("name");
			String rol = summoner.getString("rol");
			String rawSummoner = NetworkDAO.request("https://la2.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+nombre+"?api_key="+apikey1);
			JSONObject root = new JSONObject(rawSummoner);
			String puuid = root.getString("puuid");
			String id = root.getString("id");
			String name = root.getString("name");
			
			String rawLeague = NetworkDAO.request("https://la2.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+"?api_key="+apikey1);
			JSONArray main = new JSONArray(rawLeague);
			String elo;
			double ganadastemp;
			double perdidastemp;
			double totalestemp;
			double winratetemp;
			System.out.print(main.getJSONObject(0).getString("queueType"));
			if(main.getJSONObject(0).getString("queueType").equals("RANKED_FLEX_SR")) {
				JSONObject flex = main.getJSONObject(0);
				JSONObject soloq = main.getJSONObject(1);
				ganadastemp = soloq.getInt("wins");
				perdidastemp = soloq.getInt("losses");
				elo = soloq.getString("tier")+" "+soloq.getString("rank");
			}else {
				JSONObject flex = main.getJSONObject(1);
				JSONObject soloq = main.getJSONObject(0);
				ganadastemp = soloq.getInt("wins");
				perdidastemp = soloq.getInt("losses");
				elo = soloq.getString("tier")+" "+soloq.getString("rank");
			}
			totalestemp = ganadastemp + perdidastemp;
			winratetemp = ganadastemp/(totalestemp/100);
			
			int ganadas = (int)ganadastemp;
			int perdidas = (int)perdidastemp;
			int totales = (int)totalestemp;
			Double winrate = BigDecimal.valueOf(winratetemp)
				    .setScale(2, RoundingMode.HALF_UP)
				    .doubleValue();
			
			
			Summoner invocador = new Summoner();
			invocador.setElo(elo);
			invocador.setPosicion(rol);
			invocador.setTotal(totales);
			invocador.setWinrate(winrate);
			invocador.setGanadas(ganadas);
			invocador.setPerdidas(perdidas);
			invocador.setPuuid(puuid);
			invocador.setNombre(name);
			invocador.setId(id);
			System.out.print(puuid);
			listadoSummoners.add(invocador);	
		}
		
		template.addAttribute("listadoSummoners", listadoSummoners);
		return "home";
	}
	
}
