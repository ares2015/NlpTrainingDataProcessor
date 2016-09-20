package com.trainingdataprocessor.data;

/**
 * Created by Oliver on 8/31/2016.
 */
public class ISRelationshipData extends RelationshipData {

    private boolean isPresentTense;

    private int startIndex;

    private int endIndex;

    private String atomicSubject;

    private String extendedSubject;

    private String atomicPredicate;

    private String extendedPredicate;

    private String prepositionWhDetPredicate;

    public boolean isPresentTense() {
        return isPresentTense;
    }

    public void setPresentTense(boolean presentTense) {
        isPresentTense = presentTense;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getAtomicSubject() {
        return atomicSubject;
    }

    public void setAtomicSubject(String atomicSubject) {
        this.atomicSubject = atomicSubject;
    }

    public String getExtendedSubject() {
        return extendedSubject;
    }

    public void setExtendedSubject(String extendedSubject) {
        this.extendedSubject = extendedSubject;
    }

    public String getAtomicPredicate() {
        return atomicPredicate;
    }

    public void setAtomicPredicate(String atomicPredicate) {
        this.atomicPredicate = atomicPredicate;
    }

    public String getExtendedPredicate() {
        return extendedPredicate;
    }

    public void setExtendedPredicate(String extendedPredicate) {
        this.extendedPredicate = extendedPredicate;
    }

    public String getPrepositionWhDetPredicate() {
        return prepositionWhDetPredicate;
    }

    public void setPrepositionWhDetPredicate(String prepositionPredicate) {
        this.prepositionWhDetPredicate = prepositionPredicate;
    }
}