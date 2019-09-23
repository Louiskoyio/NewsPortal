package dao;

public class Sql2oUserDao {

    @Override
    public void add(Squad squad) {
        String sql = "INSERT INTO squads (name,objective) VALUES (:name,:objective)"; //raw sql
        try(Connection con = sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(squad)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            squad.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
}
