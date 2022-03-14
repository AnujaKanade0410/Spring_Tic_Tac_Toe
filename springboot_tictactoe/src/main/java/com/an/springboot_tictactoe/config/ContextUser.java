package com.an.springboot_tictactoe.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.an.springboot_tictactoe.entity.Player;
import com.google.common.collect.ImmutableSet;

public class ContextUser extends org.springframework.security.core.userdetails.User{
	private final Player player;

	
	  public ContextUser(Player player) { 
		  super(player.getUserName(),
		  player.getPasswordHash(), true, true, true, true, 
		  ImmutableSet.of(new SimpleGrantedAuthority("create")));
		  
		  this.player = player; 
	  }
	  
	  public Player getPlayer() { 
		  return player; 
	  }
	 
}
