//Further Programming Assignment 1 by Alex Huang s3628653
package model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.*;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	private Collection<Player> playerList = new ArrayList<Player>();
	private Collection<GameEngineCallback> callbackList = new ArrayList<GameEngineCallback>();

	private static final List<Slot> wheelSlots = new ArrayList<Slot>(Arrays.asList(new SlotImpl(0, Color.GREEN00, 00),
			new SlotImpl(1, Color.RED, 27), new SlotImpl(2, Color.BLACK, 10), new SlotImpl(3, Color.RED, 25),
			new SlotImpl(4, Color.BLACK, 29), new SlotImpl(5, Color.RED, 12), new SlotImpl(6, Color.BLACK, 8),
			new SlotImpl(7, Color.RED, 19), new SlotImpl(8, Color.BLACK, 31), new SlotImpl(9, Color.RED, 18),
			new SlotImpl(10, Color.BLACK, 6), new SlotImpl(11, Color.RED, 21), new SlotImpl(12, Color.BLACK, 33),
			new SlotImpl(13, Color.RED, 16), new SlotImpl(14, Color.BLACK, 4), new SlotImpl(15, Color.RED, 23),
			new SlotImpl(16, Color.BLACK, 35), new SlotImpl(17, Color.RED, 14), new SlotImpl(18, Color.BLACK, 2),
			new SlotImpl(19, Color.GREEN0, 0), new SlotImpl(20, Color.BLACK, 28), new SlotImpl(21, Color.RED, 9),
			new SlotImpl(22, Color.BLACK, 26), new SlotImpl(23, Color.RED, 30), new SlotImpl(24, Color.BLACK, 11),
			new SlotImpl(25, Color.RED, 7), new SlotImpl(26, Color.BLACK, 20), new SlotImpl(27, Color.RED, 32),
			new SlotImpl(28, Color.BLACK, 17), new SlotImpl(29, Color.RED, 5), new SlotImpl(30, Color.BLACK, 22),
			new SlotImpl(31, Color.RED, 34), new SlotImpl(32, Color.BLACK, 15), new SlotImpl(33, Color.RED, 3),
			new SlotImpl(34, Color.BLACK, 24), new SlotImpl(35, Color.RED, 36), new SlotImpl(36, Color.BLACK, 13),
			new SlotImpl(37, Color.RED, 1)));

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		Random random = new Random();
		int currentSlot = random.nextInt(wheelSlots.size() - 1);

		while (initialDelay < finalDelay) {
			for (GameEngineCallback callback : callbackList) {
				callback.nextSlot(wheelSlots.get(currentSlot), this);
			}
			try {
				Thread.sleep(initialDelay); // how much to delay by
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (currentSlot == wheelSlots.size() - 1) { // go back to first slot position when we've reached the last
														// slot
				currentSlot = 0;
			} else {
				currentSlot++; // increment to next slot
			}
			initialDelay += delayIncrement; // increment delay
		}
		for (GameEngineCallback callback : callbackList) {
			callback.result(wheelSlots.get(currentSlot), this); // send result slot
		}
	}

	@Override
	public void calculateResult(Slot winningSlot) {
		for (Player player : playerList) {
			player.getBetType().applyWinLoss(player, winningSlot);
		}
	}

	@Override
	public void addPlayer(Player player) {
		for (Player p : playerList) { // add player, overwrite if existing
			if (p.getPlayerId().equals(player.getPlayerId())) {
				playerList.remove(p);
				playerList.add(player);
				return;
			}
		}
		playerList.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player player : playerList) {
			if (player.getPlayerId().equals(id)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		if (playerList.contains(player)) {
			playerList.remove(player);
			return true;
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		callbackList.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		if (callbackList.contains(gameEngineCallback)) {
			callbackList.remove(gameEngineCallback);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableCollection(playerList);
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		if (bet > 0 && player.getPoints() >= bet) { // only place bet if non-zero and player has enough points
			player.setBet(bet);
			player.setBetType(betType);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Slot> getWheelSlots() {
		return wheelSlots;
	}

}
