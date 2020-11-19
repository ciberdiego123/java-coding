package com.example.TheMind;

import com.example.TheMind.model.Player;
import com.example.TheMind.model.Rewards;
import com.example.TheMind.model.Round;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TheMindPOC {

    public static List<Integer> cards = IntStream
            .range(1,101)
            .boxed()
            .collect(Collectors.toList());

    public static Map<Integer, Rewards> rewardsByLevel = new HashMap<>();
    static{
        rewardsByLevel.put(0, new Rewards(2, 1));
        rewardsByLevel.put(1, new Rewards(1, 0));
        rewardsByLevel.put(2, new Rewards(0, 1));
        rewardsByLevel.put(3, new Rewards(0, 0));
        rewardsByLevel.put(4, new Rewards(1, 0));
        rewardsByLevel.put(5, new Rewards(0, 1));
        rewardsByLevel.put(6, new Rewards(1, 1));
        rewardsByLevel.put(7, new Rewards(1, 0));
        rewardsByLevel.put(8, new Rewards(0, 0));
    }

    public static Round upgradeRound(Round currentRound){
        Function<Round, Round> upgradeRound = c -> {
            int level = c.getRoundLevel();
            Round newRound = new Round(c.getRoundLevel() + 1);
            newRound.setLives(c.getLives() + rewardsByLevel.get(level).getLives());
            newRound.setNumberOfShurikens(c.getNumberOfShurikens() + rewardsByLevel.get(level).getNumberOfShurikens());
            return newRound;
        };
        return upgradeRound.apply(currentRound);
    }

    public static void restoreCards(Player... players){
        cards = IntStream
                .range(1,101)
                .boxed()
                .collect(Collectors.toList());
        Stream.of(players)
                .forEach(p -> p.setCards(new ArrayList<>()));
    }

    public static void dealGame(Player player, int numberOfCards){
        List<Integer> cardsToDeal = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            cardsToDeal.add(cards.remove(0));
        }
        player.getCards().addAll(cardsToDeal);
    }

    public static boolean areSorted(List<Integer> cards){
        boolean sorted = IntStream
                .range(0, cards.size() - 1)
                .reduce(0, (ans, i) ->
                        ans + ((cards.get(i) < cards.get(i + 1)) ? 1 : 0)) == 0;
        return sorted;
    }


    public static boolean areCorrect(List<Integer> cards, Player... players){
        int lastCard = cards.stream()
                .mapToInt(e -> e)
                .max()
                .orElseThrow();
        boolean correct = Arrays.stream(players)
                .filter(p -> !p.getCards().isEmpty())
                .map(p -> p.getMinCard())
                .mapToInt(c -> c)
                .filter(c -> c < lastCard)
                .count() == 0;
        return correct;
    }


    public static void main(String[] args){
        Player diego = new Player("Diego");
        Player lily = new Player("Lily");
        Round initialRound = new Round(0);
        Round currentRound = initialRound;
        System.out.println("-------------------------------------------");
        System.out.println("-----------------The Mind------------------");
        do{
            //Give awards before playing
            currentRound = upgradeRound(currentRound);
            // Restore cards
            restoreCards(diego, lily);
            // Round
            System.out.println("-------------------------------------------");
            System.out.println("Start Round " + currentRound.getRoundLevel());
            Collections.shuffle(cards);
            // Dealing the game
            dealGame(diego, currentRound.getRoundLevel());
            dealGame(lily, currentRound.getRoundLevel());
            //Turns
            List<Integer> publicCards = new ArrayList<>();
            int expectedCards = currentRound.getRoundLevel() * 2;
            //Print game information
            System.out.println(diego);pm
            System.out.println(lily);
            System.out.println(currentRound);
            while(publicCards.size() < expectedCards){
                //Someone puts a card
                //TODO ADD THREADS FOR PLAYERS
                if(!diego.getCards().isEmpty())
                    diego.playCard(publicCards);
                else
                    lily.playCard(publicCards);
                //Check the publicCards
                if(!areCorrect(publicCards, diego, lily)){
                    currentRound.loseOneLife();
                    expectedCards--;
                    System.out.println("X " + publicCards);
                    int incorrectCard = publicCards.remove(publicCards.size()-1);
                    System.out.println("    To play "+incorrectCard+" was not correct");
                    if(currentRound.getLives() <= 0)
                        break;
                }
                System.out.println(publicCards);
            }
            System.out.println("End Round " + currentRound.getRoundLevel());
            System.out.println("-------------------------------------------");
            System.out.println("-------------------------------------------");
        }while(currentRound.getLives() > 0 && currentRound.getRoundLevel() < 8);
        System.out.println("Game is finished in round " + currentRound.getRoundLevel());
    }

}
