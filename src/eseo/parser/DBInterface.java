package eseo.parser;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInterface {
    private final static String DEFAULT_URL      = "jdbc:mysql://mysql-eseo.alwaysdata.net/eseo_projet_java";
    private final static String DEFAULT_USER     = "eseo";
    private final static String DEFAULT_PASSWORD = "eseo";
    private Connection          connection;
    PreparedStatement           preparedStatement;

    public DBInterface() {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    public void ajouterEtudiantComplet( int id, String Nom, float CoefModDonne, float ModDonne, float CoefModSpe,
            float Spe, float CoefSysInfo, float SysInfo, float CoefReseaux, float Reseaux, float CoefHF, float HF,
            float CoefRF, float RF, float CoefTraite, float Traite, float CoefAuto, float Auto, float CoefMicro,
            float Micro, float CoefCom, float Com, float CoefSem, float Sem, float CoefAng, float Ang, float CoefStage,
            float Stage ) {
        try {
            connection = DriverManager.getConnection( DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD );
        } catch ( SQLException e1 ) {
            e1.printStackTrace();
        }
        String sql = "INSERT INTO `eseo_projet_java`.`Notes` (`ID`, `ID_ESEO`, `Nom`, `CoefModDonne`, `ModDonne`, `CoefModSpe`, `Spe`, `CoefSysInfo`, `SysInfo`, `CoefReseaux`, `Reseaux`, `CoefHF`, `HF`, `CoefRF`, `RF`, `CoefTraite`, `Traite`, `CoefAuto`, `Auto`, `CoefMicro`, `Micro`, `CoefCom`, `Com`, `CoefSem`, `Sem`, `CoefAng`, `Ang`, `CoefStage`, `Stage`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement( sql );
        } catch ( SQLException e2 ) {
            e2.printStackTrace();
        }
        try {
            preparedStatement.setInt( 1, id );
        } catch ( SQLException e1 ) {
            e1.printStackTrace();
        }
        try {
            preparedStatement.setString( 2, Nom );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 3, CoefModDonne );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 4, ModDonne );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 5, CoefModSpe );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 6, Spe );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 7, CoefSysInfo );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 8, SysInfo );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 9, CoefReseaux );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 10, Reseaux );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 11, CoefHF );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 12, HF );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 13, CoefRF );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 14, RF );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 15, CoefTraite );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 16, Traite );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 17, CoefAuto );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 18, Auto );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 19, CoefMicro );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 20, Micro );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 21, CoefCom );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 22, Com );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 23, CoefSem );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 24, Sem );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 25, CoefAng );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 26, Ang );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 27, CoefStage );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 28, Stage );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.executeUpdate();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    public void ajouterEtudiant( String nom, int id, float moyenne ) {
        try {
            connection = DriverManager.getConnection( DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD );
        } catch ( SQLException e1 ) {
            e1.printStackTrace();
        }

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO `Classement` (`ID`, `Nom`, `ID_ESEO`, `Moyenne`) VALUES(NULL,?,?,?);";
        String sql_update = "UPDATE  `eseo_projet_java`.`Classement` SET  `Moyenne` =  ? WHERE  `Classement`.`Nom` = ?";
        try {
            preparedStatement = connection.prepareStatement( sql );
        } catch ( SQLException e2 ) {
            e2.printStackTrace();
        }

        try {
            preparedStatement.setString( 1, nom );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setInt( 2, id );
        } catch ( SQLException e1 ) {
            e1.printStackTrace();
        }
        try {
            preparedStatement.setFloat( 3, moyenne );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }

        try {
            preparedStatement.executeUpdate();
        } catch ( com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex ) {
            try {
                preparedStatement = connection.prepareStatement( sql_update );
            } catch ( SQLException e2 ) {
                e2.printStackTrace();
            }
            try {
                preparedStatement.setFloat( 1, moyenne );
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
            try {
                preparedStatement.setString( 2, nom );
            } catch ( SQLException e1 ) {
                e1.printStackTrace();
            }
            try {
                preparedStatement.executeUpdate();
            } catch ( SQLException e ) {
                e.printStackTrace();

            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    public void afficherClassement() {
        try {
            connection = DriverManager.getConnection( DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD );
        } catch ( SQLException e1 ) {
            e1.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        String sql = "SELECT    Nom, Moyenne,@curRank := @curRank + 1 AS Classement FROM Classement c, (SELECT @curRank := 0) r ORDER BY  Moyenne DESC LIMIT 0,300;";
        try {
            preparedStatement = connection.prepareStatement( sql );
        } catch ( SQLException e2 ) {
            e2.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = preparedStatement.executeQuery();
        } catch ( SQLException e3 ) {
            e3.printStackTrace();
        }
        try {
            while ( rs.next() ) {
                String userName = rs.getString( "Nom" );
                String userMoyenne = rs.getString( "Moyenne" );
                String userClassement = rs.getString( "Classement" );
                System.out.println( userName + " " + userMoyenne + " " + userClassement );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
}
