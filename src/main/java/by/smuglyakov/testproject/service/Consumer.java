package by.smuglyakov.testproject.service;

public interface Consumer {

    /**
     * Called periodically to consume an integer.
     */
    void accept(int number);

    /**
     * Returns the mean (aka average) of numbers consumed in the
     * last 5 minutes period.
     * */
    Double mean();

}
