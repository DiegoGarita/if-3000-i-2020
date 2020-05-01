package edu.ucr.rp.lab03.generator;

public class PasswordGeneratorBuilder {

    private Integer minSpecialChars;
    private Integer minUpperCase;
    private Integer minNumbers;
    private Integer minLength;
    private char[] specialChars;
    private Integer maxLength;

    public PasswordGeneratorBuilder withMinSpecialChars(Integer minSpecialChars) {
        this.minSpecialChars = minSpecialChars;
        return this;
    }

    public PasswordGeneratorBuilder withMinUpperCase(Integer minUpperCase) {
        this.minUpperCase = minUpperCase;
        return this;
    }

    public PasswordGeneratorBuilder withMinNumbers(Integer minNumbers) {
        this.minNumbers = minNumbers;
        return this;
    }

    public PasswordGeneratorBuilder withMinLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    public PasswordGeneratorBuilder withSpecialChars(char[] specialChars) {
        this.specialChars = specialChars;
        return this;
    }

    public PasswordGeneratorBuilder withMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public PasswordGenerator build() {
        if (maxLength == null) {
            maxLength = Integer.MAX_VALUE;
        }

        return new PasswordGenerator(minSpecialChars, minUpperCase, minNumbers, minLength, specialChars, maxLength);

    }

}
