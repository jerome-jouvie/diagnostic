package fr.softwaymedical.diagnostic.domain;

import java.util.Set;

public record Diagnostic(Set<Pathologie> pathologies) {
}
