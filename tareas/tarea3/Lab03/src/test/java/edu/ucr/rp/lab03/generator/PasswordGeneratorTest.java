package edu.ucr.rp.lab03.generator;

import java.util.stream.Stream;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class PasswordGeneratorTest {

    PasswordGeneratorBuilder builder = new PasswordGeneratorBuilder();

    @Before
    public void setup() {
        builder
                .withSpecialChars(new char[]{'#', '@', ')'})
                .withMinNumbers(1)
                .withMinLength(8)
                .withMinSpecialChars(1)
                .withMinUpperCase(1);
    }

    /**
     * Scenario: Generar un password con al menos 1 mayúscula - Given: Cantidad
     * mínima de mayúscula -> Precondiciones
     *
     * - When: Generamos el password -> Acción a probar
     *
     * - Then: El password contiene al menos mayúscula -> Validaciones
     */
    //@Test
    public void givenAnUppercaseAPasswordIsGenerated() {

        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();

        Assert.assertTrue("Invalid number of uppercase", getUpperCases(password) >= 1);

    }

    private long getUpperCases(String password) {

        return password.chars().filter(letter -> Character.isUpperCase(letter)).count();
    }

    /**
     * Scenario: generar un password con al menos 1 carácter especial -Given:
     * Cantidad minima de 1 carácter especial -And: Una lista de caracteres
     * -When: Generamos el password -Then: El password contiene al menos un
     * carácter especial de la lista de caracteres
     *
     *
     */
    //@Test
    public void givenASpecialCharsAPasswordIsGenerated() {
        PasswordGeneratorBuilder builder = new PasswordGeneratorBuilder();
        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();

        Assert.assertTrue("Invalid number of uppercase", getUpperCases(password) >= 1);
        Assert.assertTrue("Invalid special chars", containsSpecialChars(password, '#', '@', ')'));
        Assert.assertTrue("Invalid number of special chars", getSpecialCases(password) >= 1);

    }

    private long getSpecialCases(String password) {

        return password.chars().filter(it -> !Character.isLetter(it) && !Character.isDigit(it)).count();
    }

    private boolean containsSpecialChars(String password, Character... specialChars) {
        //"edre$%" ->[e,d,r,e,$,%]
        return password.chars()
                .filter(specialChar -> Stream.of(specialChars).filter(param -> specialChar == param).findAny().isPresent()).findAny().isPresent();

    }

    /**
     * Scenario: Generar un password que complete su minima longitud con
     * minúsculas si es necesario - Given: Cantidad faltante cubierta por
     * minúsculas -> Precondiciones
     *
     * - When: Generamos el password -> Acción a probar
     *
     * - Then: El password contiene las minusculas necesarias -> Validaciones
     */
    //@Test
    public void givenALowercaseAPasswordIsGenerated() { //por defecto tiene minúsculas para rellenar la contraseña

        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();

        Assert.assertTrue("Invalid number of lower", getLowerCases(password) >= 0);

    }

    private long getLowerCases(String password) {

        return password.chars().filter(letter -> Character.isLowerCase(letter)).count();
    }

    /**
     * Scenario: Generar un password con al menos 2 números - Given: Cantidad
     * mínima de numeros -> Precondiciones
     *
     * - When: Generamos el password -> Acción a probar
     *
     * - Then: El password contiene al menos 2 números -> Validaciones
     */
    //@Test
    public void givenANumberAPasswordIsGenerated() {

        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();

        Assert.assertTrue("Invalid number of numbers", getminNumbers(password) >= 2);

    }

    private long getminNumbers(String password) {

        return password.chars().filter(number -> Character.isDigit(number)).count();
    }

    /**
     * Scenario: Generar un password con un máximo de 3 caracteres especiales
     *
     * - Given: Cantidad máxima de caracteres especiales -> Precondiciones
     *
     * - When: Generamos el password -> Acción a probar
     *
     * - Then: El password contiene un máximo de 3 caracteres especiales->
     * Validaciones
     */
    //@Test
    public void givenAMaxSpecialCharsAPasswordIsGenerated() {

        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();

        Assert.assertTrue("Invalid number of specialChars", getmaxSpecialChars(password) <= 3);

    }

    private long getmaxSpecialChars(String password) {

        return password.chars().filter(chars -> Character.isDefined(chars)).count();
    }

    /**
     * Scenario: Generar un password con un tamaño mínimo definido (de 8)
     *
     * - Given: Cantidad mínima de caracteres -> Precondiciones
     *
     * - When: Generamos el password -> Acción a probar
     *
     * - Then: El password es al menos del tamaño mínimo definido-> Validaciones
     */
    //@Test
    public void givenAMinLengthPasswordIsGenerated() {

        PasswordGenerator passwordGenerator = builder.build();

        String password = passwordGenerator.generate();

        Assert.assertTrue("Invalid number of minLength", getminLength(password) >= 8);

    }

    private long getminLength(String password) {

        return password.chars().filter(length -> Character.isLetterOrDigit(length)).count();
    }

}
