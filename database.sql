-- ================================================================
-- Script de base de datos para PostgreSQL
-- Base de datos: partido_politico_db
-- ================================================================

-- ----------------------------------------------------------------
-- Tabla de partidos politicos
-- ----------------------------------------------------------------
CREATE TABLE IF NOT EXISTS partidos_politicos (
    id VARCHAR(36) PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    eslogan VARCHAR(180) NOT NULL,
    presidente VARCHAR(100) NOT NULL,
    secretario VARCHAR(100) NOT NULL,
    tesorero VARCHAR(100) NOT NULL,
    pais VARCHAR(80) NOT NULL,
    num_presidentes INTEGER NOT NULL DEFAULT 0,
    num_gobernadores INTEGER NOT NULL DEFAULT 0,
    num_alcaldes INTEGER NOT NULL DEFAULT 0,
    num_concejales INTEGER NOT NULL DEFAULT 0,
    num_congresistas INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_partidos_politicos_nombre ON partidos_politicos (nombre);
CREATE INDEX IF NOT EXISTS idx_partidos_politicos_pais ON partidos_politicos (pais);

-- ----------------------------------------------------------------
-- Datos de ejemplo (opcional)
-- ----------------------------------------------------------------
INSERT INTO partidos_politicos (id, nombre, eslogan, presidente, secretario, tesorero, pais,
    num_presidentes, num_gobernadores, num_alcaldes, num_concejales, num_congresistas)
VALUES (
    'b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e',
    'Partido Liberal',
    'Por la libertad y el progreso',
    'Carlos Restrepo',
    'Ana Gomez',
    'Jorge Morales',
    'Colombia',
    3, 8, 45, 120, 78
);