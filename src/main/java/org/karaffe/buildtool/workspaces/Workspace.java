package org.karaffe.buildtool.workspaces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.karaffe.buildtool.workspaces.projects.Project;

public abstract class Workspace {
    private final Configuration configuration;
    private final Set<Project> projects;

    public Workspace(Configuration configuration, Project... projects) {
        this.configuration = configuration;
        this.projects = new HashSet<>(Arrays.asList(projects));
    }

    public Set<Project> getProjects() {
        return new HashSet<>(this.projects);
    }

    public boolean hasAnyProject() {
        return !this.projects.isEmpty();
    }

    public boolean hasProject(Project project) {
        return this.projects.contains(project);
    }

    public Optional<Project> getProject(String projectName) {
        return this.projects.stream().filter(project -> project.getName().equals(projectName)).findFirst();
    }

    public <R> Stream<R> runMatchedProjects(Predicate<? super Project> f, Function<? super Project, R> function) {
        return this.projects.stream().filter(f).map(function);
    }

    public <R> Stream<R> runAllProjects(Function<? super Project, R> function) {
        return this.projects.stream().map(function);
    }

}
