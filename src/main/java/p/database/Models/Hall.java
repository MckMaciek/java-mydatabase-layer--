package p.database.Models;

import p.database.Annotations.Getter;
import p.database.Annotations.Setter;

public class Hall {

    private String id;
    private String name;
    private String hall_columns;
    private String hall_rows;
    private String has_section;
    private String additional_seats ;


    @Getter(columnName = "id")
    public String getId() {
        return id;
    }

    @Setter(columnName = "id")
    public void setId(String id) {
        this.id = id;
    }

    @Getter(columnName = "name")
    public String getName() {
        return name;
    }

    @Setter(columnName = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Getter(columnName = "hall_columns")
    public String getHall_columns() {
        return hall_columns;
    }

    @Setter(columnName = "hall_columns")
    public void setHall_columns(String hallColumns) {
        this.hall_columns = hallColumns;
    }

    @Getter(columnName = "hall_rows")
    public String getHall_rows() {
        return hall_rows;
    }

    @Setter(columnName = "hall_rows")
    public void setHall_rows(String hallRows) {
        this.hall_rows = hallRows;
    }

    @Getter(columnName = "has_section")
    public String getHas_Section() {
        return has_section;
    }

    @Setter(columnName = "has_section")
    public void setHas_Section(String hasSection) {
        this.has_section = hasSection;
    }

    @Getter(columnName = "additional_seats")
    public String getAdditional_seats() {
        return additional_seats;
    }

    @Setter(columnName = "additional_seats")
    public void setAdditional_seats(String additional_seats) {
        this.additional_seats = additional_seats;
    }


    public Hall(){

    }

    public static class HallBuilder{
        private String name;
        private String hallColumns;
        private String hallRows;
        private String hasSection;
        private String additional_seats ;
        private String id;

        public HallBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HallBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public HallBuilder setHallColumns(String hallColumns) {
            this.hallColumns = hallColumns;
            return this;
        }

        public HallBuilder setHallRows(String hallRows) {
            this.hallRows = hallRows;
            return this;
        }

        public HallBuilder setHasSection(String hasSection) {
            this.hasSection = hasSection;
            return this;
        }

        public HallBuilder setAddSeats(String addSeats) {
            this.additional_seats  = addSeats;
            return this;
        }

        public Hall build(){
            Hall hall = new Hall();

            hall.hall_columns = this.hallColumns;
            hall.hall_rows = this.hallRows;
            hall.has_section = this.hasSection;
            hall.additional_seats  = this.additional_seats;
            hall.name = this.name;
            hall.id = this.id;

            return hall;
        }

    }
    public static HallBuilder getInstanceOfHallBuilder(){
        return new HallBuilder();
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hallColumns='" + hall_columns + '\'' +
                ", hallRows='" + hall_rows + '\'' +
                ", hasSection='" + has_section + '\'' +
                ", additional_seats='" + additional_seats + '\'' +
                '}';
    }
}
