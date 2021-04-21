package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.History;
import p.database.Models.Registration;
import p.database.Operations.DeleteConcrete;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;
import p.database.Operations.UpdateConcrete;

import java.util.Scanner;

@Service
public class HistoryService implements TableService {
    private History history;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    private final SelectConcrete<History> selectConcrete;
    private final InsertConcrete<History> insertConcrete;
    private final DeleteConcrete<History> deleteConcrete;
    private final UpdateConcrete<History> updateConcrete;

    @Autowired
    public HistoryService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();

        selectConcrete = new SelectConcrete<>();
        insertConcrete = new InsertConcrete<>();
        deleteConcrete = new DeleteConcrete<>();
        updateConcrete = new UpdateConcrete<>();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "history_tb";
    }

    public void ScanInput() {
        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("ID ");
        Long id = getCommandFromUser.nextLong();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("NAME ");
        String name = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("NAME ");
        String iterations = getCommandFromUser.nextLine();

        history = new History.HistoryBuilder()
                .setId(id)
                .setName(name)
                .setIterations(iterations)
                .build();

    }

    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.select(this.getName(), possibleWhereStatement, History.class);
    }

    @Override
    public void update() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        //ScanInput();

        updateConcrete.update(this.getName(), possibleWhereStatement, columnNames, history,  History.class);
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        ScanInput();

        insertConcrete.insert(this.getName(), columnNames, history,  History.class);
    }

    @Override
    public void delete() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        deleteConcrete.delete(this.getName(), possibleWhereStatement);
    }
}
