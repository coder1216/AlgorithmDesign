package HumanResource;

import javafx.geometry.Pos;

import java.util.*;

public abstract class People {
    final String id;
    final String name;

    final List<People> directReport;
    final List<EmailReceiver> emailReceivers;
    final List<UpMessageDispatcher> upMessageDisPatchers;
    final List<DownMessageDispatcher> downMessageDispatchers;

    People directSupervisor;

    Position position;

    public People(final String id, final String name) {
        this.id = id;
        this.name = name;

        directReport = new ArrayList<>();
        emailReceivers = new ArrayList<>();
        upMessageDisPatchers = new ArrayList<>();
        downMessageDispatchers = new ArrayList<>();
    }

    public int getLevel() {
        if (position == null) return 0;
        return position.level;
    }

    public boolean setDirectReporter(final People people) {
        if (people.getLevel() >= this.getLevel()) {
            directSupervisor = people;
        }
        return false;
    }

    public boolean addDirectReporter(final People people) {
        if (people.getLevel() <= this.getLevel()) {
            directReport.add(people);
            people.setDirectReporter(this);
            return true;
        }
        return false;
    }

    public void sendSupervisorsMessage(final String message) {
        if (directSupervisor != null) {
            directSupervisor.onReportersMessageReceived(message);
        }

        for (UpMessageDispatcher supervisor : upMessageDisPatchers) {
            supervisor.onMessageReceived(message);
        }
    }

    public void sendReportersMessage(final String message){
        for(People reporter : directReport) {
            reporter.onSupervisorMessageReceived(message);
        }

        for(DownMessageDispatcher reporters : downMessageDispatchers) {
            reporters.onMessageReceived(message);
        }
    }

    public void sendEmail(String emailMessage) {
        for (EmailReceiver emailReceiver : emailReceivers) {
            emailReceiver.onEmailMessageReceived(emailMessage);
        }
    }

    public void addEmailReceiver(final EmailReceiver iEmailReceiver){
        emailReceivers.add(iEmailReceiver);
    }

    public void removeEmailReceiver(final EmailReceiver iEmailReceiver){
        emailReceivers.remove(iEmailReceiver);
    }



    public abstract void onSupervisorMessageReceived(String message);
    public abstract void onReportersMessageReceived(String message);
}
