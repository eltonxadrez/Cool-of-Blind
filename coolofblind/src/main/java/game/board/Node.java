package game.board;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node {
    private String name;
    private Integer x,y;
}
