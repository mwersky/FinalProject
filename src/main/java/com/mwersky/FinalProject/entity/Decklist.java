package com.mwersky.FinalProject.entity;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
//import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "decklist")
@AssociationOverrides({
        @AssociationOverride(name = "pk.deck", 
            joinColumns = @JoinColumn(name = "deck_id")),
        @AssociationOverride(name = "pk.card", 
            joinColumns = @JoinColumn(name = "card_id")) })
public class Decklist implements java.io.Serializable {

    private DecklistId pk = new DecklistId();
    private int amount;

    public Decklist() {
    }

    @EmbeddedId //ctrl click DecklistId to see Primary key info
    public DecklistId getPk() {
        return pk;
    }

    public void setPk(DecklistId pk) {
        this.pk = pk;
    }

//    @Transient //guide uses this tool. not sure it works for me.
    public Deck getDeck() {
        return getPk().getDeck();
    }

    public void setDeck(Deck deck) {
        getPk().setDeck(deck);
    }

//    @Transient
    public Card getCard() {
        return getPk().getCard();
    }

    public void setCard(Card card) {
        getPk().setCard(card);
    }

    @Column(name = "card_amount", nullable = false)
    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Decklist that = (Decklist) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}