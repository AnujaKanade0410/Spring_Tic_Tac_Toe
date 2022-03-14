package com.an.springboot_tictactoe.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import com.an.springboot_tictactoe.entity.Player;
import com.an.springboot_tictactoe.repository.PlayerRepository;

import static com.google.common.base.Preconditions.checkNotNull;


public class UserDetailsServiceImpl implements UserDetailsService{
	   private final PlayerRepository playerRepository;

	   @Autowired
	   public UserDetailsServiceImpl(PlayerRepository playerRepository) {
	       this.playerRepository = playerRepository;
	   }

	   @Override
	   @Transactional
	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	       checkNotNull(username);

	       if(StringUtils.isEmpty(username)) {
	           throw new UsernameNotFoundException("Username cannot be empty");
	       }

	       Player player = playerRepository.findOneByUserName(username);
	       if (player == null) {
	           throw new UsernameNotFoundException("Player " + username + " doesn't exists");
	       }
	       return new ContextUser(player);
	   }
}
