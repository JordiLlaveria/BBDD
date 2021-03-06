package edu.upc.eetac.dsa.util;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("ID");
        for (String field: fields) {
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Class theclass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theclass.getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }
    public static String createQuerySELECTALL(Class theclass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theclass.getSimpleName());

        return sb.toString();
    }

    public static String createQueryDELETE(Object entity){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }

    public static String createQueryUPDATE(Object entity){
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("SET ");

        String [] fields = ObjectHelper.getFields(entity);
        int i =0;
        for (String field: fields) {
            if (i<fields.length-1){
                sb.append(field);
                sb.append(" = ?, " );
            }
            else{
                sb.append(field);
                sb.append(" = ? " );
            }
            i++;
        }

        sb.append("WHERE ID = ?");

        return sb.toString();
    }
}
