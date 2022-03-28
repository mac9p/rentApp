package com.mac9p.rentapp.Commands;

import com.mac9p.rentapp.Model.Disc;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private List<Disc> discsRented;
    private String firstName;
    private String lastName;

}
