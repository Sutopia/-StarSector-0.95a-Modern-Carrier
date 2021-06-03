package data.missions.operationtango;

import java.util.List;

import com.fs.starfarer.api.combat.BaseEveryFrameCombatPlugin;
import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;

import com.fs.starfarer.api.impl.campaign.AICoreOfficerPluginImpl;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;

public class MissionDefinition implements MissionDefinitionPlugin {

	public void defineMission(MissionDefinitionAPI api) {

		AICoreOfficerPluginImpl AIOfficer = new AICoreOfficerPluginImpl();
		// Set up the fleets
		api.initFleet(FleetSide.PLAYER, "HSS", FleetGoal.ATTACK, false, 10);
		api.initFleet(FleetSide.ENEMY, "TTF", FleetGoal.ATTACK, true, 30);

		// Set a blurb for each fleet
		api.setFleetTagline(FleetSide.PLAYER, "Members of Operation Tango");
		api.setFleetTagline(FleetSide.ENEMY, "Autonomous Nexus guarded by Tri-Tachyon Special Task Force 58");
		
		// These show up as items in the bulleted list under 
		// "Tactical Objectives" on the mission detail screen
		api.addBriefingItem("Destroy TTDS Heaven, the nexus, at all cost");
		api.addBriefingItem("The HSS Yamatoe must survive");
		
		// Set up the player's fleet
		api.addToFleet(FleetSide.PLAYER, "onslaught_xiv_Elite", FleetMemberType.SHIP, "HSS Yamatoe", true);
		api.addToFleet(FleetSide.PLAYER, "dominator_XIV_Elite", FleetMemberType.SHIP, false);
		
		api.addToFleet(FleetSide.PLAYER, "enforcer_XIV_Elite", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "enforcer_XIV_Elite", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "enforcer_XIV_Elite", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "enforcer_XIV_Elite", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "enforcer_XIV_Elite", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "enforcer_XIV_Elite", FleetMemberType.SHIP, false);
		
		api.addToFleet(FleetSide.PLAYER, "enforcer_Escort", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "enforcer_Escort", FleetMemberType.SHIP, false);
		
		api.addToFleet(FleetSide.PLAYER, "lasher_PD", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "lasher_PD", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.PLAYER, "lasher_PD", FleetMemberType.SHIP, false);
		
		// Mark player flagship as essential
		api.defeatOnShipLoss("HSS Yamatoe");
		
		// Set up the enemy fleet
		api.addToFleet(FleetSide.ENEMY, "remnant_station_Standard_su", FleetMemberType.SHIP, "TTDS Heaven", false).setCaptain(AIOfficer.createPerson(Commodities.ALPHA_CORE, "neutral", null));
		
		api.addToFleet(FleetSide.ENEMY, "brilliant_Standard", FleetMemberType.SHIP, "TTDS Guan", false);
		api.addToFleet(FleetSide.ENEMY, "brilliant_Standard", FleetMemberType.SHIP, "TTDS Alaskan", false);
		
		api.addToFleet(FleetSide.ENEMY, "scintilla_mc_Overlord", FleetMemberType.SHIP, "TTDS CV-9", false).setCaptain(AIOfficer.createPerson(Commodities.BETA_CORE, "neutral", null));
		api.addToFleet(FleetSide.ENEMY, "scintilla_mc_Overlord", FleetMemberType.SHIP, "TTDS CV-11", false).setCaptain(AIOfficer.createPerson(Commodities.BETA_CORE, "neutral", null));
		api.addToFleet(FleetSide.ENEMY, "scintilla_mc_Overlord", FleetMemberType.SHIP, "TTDS CV-17", false).setCaptain(AIOfficer.createPerson(Commodities.BETA_CORE, "neutral", null));
		api.addToFleet(FleetSide.ENEMY, "scintilla_mc_Overlord", FleetMemberType.SHIP, "TTDS CV-19", false).setCaptain(AIOfficer.createPerson(Commodities.BETA_CORE, "neutral", null));
		
		api.addToFleet(FleetSide.ENEMY, "astral_su_Task", FleetMemberType.SHIP, "TTF CV-12", false);
		api.addToFleet(FleetSide.ENEMY, "astral_su_Task", FleetMemberType.SHIP, "TTF CV-20", false);
		
		api.addToFleet(FleetSide.ENEMY, "heron_su_Blitz", FleetMemberType.SHIP, "TTF CVL-24", false);
		api.addToFleet(FleetSide.ENEMY, "heron_su_Blitz", FleetMemberType.SHIP, "TTF CVL-30", false);
		api.addToFleet(FleetSide.ENEMY, "heron_su_Blitz", FleetMemberType.SHIP, "TTF CVL-11", false);
		api.addToFleet(FleetSide.ENEMY, "heron_su_Blitz", FleetMemberType.SHIP, "TTF CVL-27", false);
		api.addToFleet(FleetSide.ENEMY, "heron_su_Blitz", FleetMemberType.SHIP, "TTF CVL-29", false);
		
		api.defeatOnShipLoss("TTDS Heaven");
		
		// Set up the map.
		float width = 18000f;
		float height = 18000f;
		api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);
		
		float minX = -width/2;
		float minY = -height/2;
		
		for (int i = 0; i < 15; i++) {
			float x = (float) Math.random() * width - width/2;
			float y = (float) Math.random() * height - height/2;
			float radius = 100f + (float) Math.random() * 900f; 
			api.addNebula(x, y, radius);
		}
		api.setBackgroundSpriteName("graphics/backgrounds/hyperspace1.jpg");
		//api.setBackgroundSpriteName("graphics/backgrounds/background2.jpg");
		
		//system.setBackgroundTextureFilename("graphics/backgrounds/background2.jpg");
		//api.setBackgroundSpriteName();
		
		// Add an asteroid field going diagonally across the
		// battlefield, 2000 pixels wide, with a maximum of 
		// 100 asteroids in it.
		// 20-70 is the range of asteroid speeds.
		api.addAsteroidField(0f, 0f, (float) Math.random() * 360f, width,
									20f, 70f, 100);
		
		
		api.addPlugin(new BaseEveryFrameCombatPlugin() {
			public void advance(float amount, List events) {
			}
			public void init(CombatEngineAPI engine) {
				engine.getContext().setStandoffRange(10000f);
			}
		});
	}

}






