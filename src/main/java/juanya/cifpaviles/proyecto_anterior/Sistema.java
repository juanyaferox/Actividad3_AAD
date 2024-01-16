/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanya.cifpaviles.proyecto_anterior;

import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author juanya
 */
public class Sistema {

    //METODOS CASO REGISTRO
    public static boolean Verificacion(Connection connection, String nombre, String nacionalidad) throws SQLException {
        String sqlQuery = "SELECT * FROM `tperegrino` WHERE `cnombre` LIKE ? AND `cnacionalidad` LIKE ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, nacionalidad);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public static void Registro(Connection connection, String usuario, String contrasenia, String nombre, String nacionalidad) throws SQLException {
        LocalDate fecha = LocalDate.now();
        Date sqlDate = Date.valueOf(fecha);
        //creo una nueva fila la cual será el carnet del usuario actual
        String sqlQueryTCarnet = "INSERT INTO `tcarnet` (`pkid`, `fkid_parada`, `fechaexp`) VALUES (NULL, NULL, ?);";
        try (PreparedStatement preparedStatementTCarnet = connection.prepareStatement(sqlQueryTCarnet, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatementTCarnet.setDate(1, sqlDate);
            preparedStatementTCarnet.executeUpdate();
            try (ResultSet generatedKeys = preparedStatementTCarnet.getGeneratedKeys()) {
                int pkidCarnet = generatedKeys.getInt(1);
                String sqlQueryTPeregrino = "INSERT INTO `tperegrino` (`pkfkid`,`cnombre`,`cnacionalidad`) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatementTPeregrino = connection.prepareStatement(sqlQueryTPeregrino)) {
                    preparedStatementTPeregrino.setInt(1, pkidCarnet);
                    preparedStatementTPeregrino.setString(2, nombre);
                    preparedStatementTPeregrino.setString(3, nacionalidad);
                    preparedStatementTPeregrino.executeUpdate();
                }
                String sqlQueryTPerfil = "INSERT INTO `tperfil` (`pkid_usuario`,`cpassword`,`fk_idperegrino`,`fk_idparada`) VALUES (?, ?, ?, NULL)";
                try (PreparedStatement preparedStatementTPerfil = connection.prepareStatement(sqlQueryTPerfil)) {
                    preparedStatementTPerfil.setString(1, usuario);
                    preparedStatementTPerfil.setString(2, contrasenia);
                    preparedStatementTPerfil.setInt(3, pkidCarnet);
                    preparedStatementTPerfil.executeUpdate();
                }
            }
        }
    }

    public static boolean VerificarUsuario(Connection connection, String usuario) throws SQLException {
        String sqlQuery = "SELECT * FROM `tperfil` WHERE `pkid_usuario` LIKE ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, usuario);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------
    //MÉTODOS CASO LOGIN
    public static boolean VerificarPerfil(Connection connection, String usuario, String contrasenia, String tipoPerfil) throws SQLException {
        String sqlQuery = "SELECT * FROM `tperfil` WHERE `pkid_usuario` LIKE ? AND `cpassword` LIKE ? AND `" + tipoPerfil + "` IS NULL";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasenia);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public static boolean VerificarParada(Connection connection, String nombre, String region) throws SQLException {
        String sqlQuery = "SELECT * FROM `tparada` WHERE `cnombre` LIKE ? AND `cregion` LIKE ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, region);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public static void RegistrarParada(Connection connection, String nombre, String region, String usuario, String contrasenia) throws SQLException {
        String sqlQueryTParada = "INSERT INTO `tparada` (`pkid`, `cnombre`, `cregion`) VALUES (NULL, ?, ?);";
        try (PreparedStatement preparedStatementTParada = connection.prepareStatement(sqlQueryTParada, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatementTParada.setString(1, nombre);
            preparedStatementTParada.setString(2, region);
            preparedStatementTParada.executeUpdate();
            try (ResultSet generatedKeys = preparedStatementTParada.getGeneratedKeys()) {
                int pkidParada = generatedKeys.getInt(1);
                String sqlQueryTPerfil = "INSERT INTO `tperfil` (`pkid_usuario`,`cpassword`,`fk_idperegrino`,`fk_idparada`) VALUES (?, ?, NULL, ?)";
                try (PreparedStatement preparedStatementTPerfil = connection.prepareStatement(sqlQueryTPerfil)) {
                    preparedStatementTPerfil.setString(1, usuario);
                    preparedStatementTPerfil.setString(2, contrasenia);
                    preparedStatementTPerfil.setInt(3, pkidParada);
                    preparedStatementTPerfil.executeUpdate();
                    System.out.println("Parada y usuario registrados con exito");
                }
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------
    //MÉTODOS EXPORTAR PARADAS
    public static int GetIdParada(Connection connection, String usuario) {
        int idParada = -1;
        String sqlQuery = "SELECT fkid_parada FROM tperfil WHERE pkid_usuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, usuario);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Obtener el valor de la columna "fk_idparada"
                    idParada = resultSet.getInt("fkid_parada");

                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return idParada;
    }

    public static void SelectParada(Connection connection, int idParada) {
        String sqlQuery = "SELECT * FROM `tparada` WHERE `pkid` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idParada);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int pkid = resultSet.getInt("pkid");
                    String cnombre = resultSet.getString("cnombre");
                    String cregion = resultSet.getString("cregion");
                    System.out.print("PARADA -> ID: " + pkid + " Nombre: " + cnombre + " Region: " + cregion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean ValidarRangoFechas(LocalDate fecha1, LocalDate fecha2) {
        // Verificar que fecha1 no sea mayor que fecha2
        if (fecha1.isAfter(fecha2) || fecha1.isEqual(fecha2)) {
            System.out.println("Error: Rango de fechas inválido. La fecha1 no puede ser mayor o igual a la fecha2.");
            return false;
        }

        // Rango de fechas válido
        System.out.println("Rango de fechas válido.");
        return true;
    }

    public static void GetEstancias(Connection connection, LocalDate fecha1, LocalDate fecha2, int IdParada) throws SQLException {
        String sqlQuery = "SELECT testancia.*, tperegrino.cnombre "
                + "FROM testancia "
                + "LEFT JOIN tperegrino ON testancia.fkid_peregrino = tperegrino.pkfkid "
                + "LEFT JOIN tparada ON testancia.fkid_parada = tparada.pkid "
                + "WHERE testancia.fecha BETWEEN ? AND ? AND tparada.pkid = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            Date fecha1Sql = Date.valueOf(fecha1);
            Date fecha2Sql = Date.valueOf(fecha2);
            preparedStatement.setDate(1, fecha1Sql);
            preparedStatement.setDate(2, fecha2Sql);
            preparedStatement.setInt(3, IdParada);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int pkid = resultSet.getInt("pkid");
                    String cnombre = resultSet.getString("cnombre");
                    Date fecha = resultSet.getDate("fecha");
                    int VIP = resultSet.getInt("VIP");

                    System.out.println("ID Estancia -> " + pkid
                            + "\n Nombre Peregrino -> " + cnombre
                            + "\n Fecha -> " + fecha
                            + "\n VIP -> " + VIP);
                }
            }
        }

    }

    //---------------------------------------------------------------------------------------------------------------
    //MÉTODOS SELLAR
    public static void SelectPeregrino(Connection connection, int idperegrino) {
        String sqlQuery = " SELECT tperegrino.* FROM tperegrino WHERE pkfkid=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idperegrino);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int pkfkid = resultSet.getInt("pkfkid");
                    String cnombre = resultSet.getString("cnombre");
                    String cnacionalidad = resultSet.getString("cnacionalidad");
                    System.out.println("PEREGRINO -> ID: " + pkfkid + " Nombre: " + cnombre + " Nacionalidad: " + cnacionalidad);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void RegistroParadaPeregrino(Connection connection, int idparada, int idperegrino) {
        String sqlQuery = "INSERT INTO `tperegrino_parada` (`pkfkid_parada`, `pkfkid_peregrino`) VALUES (?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idperegrino);
            preparedStatement.setInt(2, idparada);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void UpdateTablaCarnet(Connection connection, int idperegrino){
        String sqlQuery = "UPDATE tcarnet SET distancia = distancia + 5 WHERE pkid = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idperegrino);
            preparedStatement.executeUpdate();
            System.out.println("Éxito en el sellado");
        }   catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void CreateEstancia(Connection connection, int idparada, int idperegrino, int vip){
        String sqlQuery = "INSERT INTO testancia (fkid_parada,fkid_peregrino,fecha,vip) VALUES (?,?,?,?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idparada);
            preparedStatement.setInt(2, idperegrino);
            preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(4, vip);
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void InsertCarnet(Connection connection, int idperegrino, int nvipcarne){
        String sqlQuery = "UPDATE INTO tcarnet SET nvips = nvips+"+nvipcarne+" WHERE pkid=?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, idperegrino);
            preparedStatement.executeUpdate();
            System.out.println("Operación exitosa");
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
