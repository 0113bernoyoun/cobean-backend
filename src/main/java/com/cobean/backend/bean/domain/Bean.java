package com.cobean.backend.bean.domain;

import com.cobean.backend.roasters.domain.Roasters;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;

@Entity
@Getter
public class Bean {

    @Id
    @Column(name = "bean_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "roasters_id")
    private Roasters roasters;

    private Integer size;

    private Long likes;

    private String cupnoteList;

    private String description;

    private String descriptionImageURL;


    public Bean(String name, Integer size, Long price, Roasters roasters, String cupnoteList, String description, String descriptionImageURL) {
        Assert.hasText(cupnoteList, "컵노트는 반드시 채워야합니다.");

        this.name = name;
        this.size = size;
        this.price = price;
        this.roasters = roasters;
        this.roasters.addBean(this);
        this.likes = 0L;
        this.cupnoteList = "#" + cupnoteList;
        this.description = description;
        this.descriptionImageURL = descriptionImageURL;
    }

    protected Bean() {
    }


    public void addCupnote(String cupnote) {
        final String seperator = "#";

        if (!this.cupnoteList.isEmpty()) {
            this.cupnoteList += seperator + cupnote;
        } else {
            this.cupnoteList = cupnote;
        }

    }

}
