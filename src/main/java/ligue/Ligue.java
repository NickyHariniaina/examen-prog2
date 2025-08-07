package ligue;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Ligue {

  private final String nom;
  private List<Combattant> combattants = new ArrayList<>();
  private List<Match> matchs = new ArrayList<>();
}
