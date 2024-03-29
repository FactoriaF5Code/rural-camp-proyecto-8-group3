--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id_books integer NOT NULL,
    title character varying(50) NOT NULL,
    author character varying(50) NOT NULL,
    status character varying(20) NOT NULL,
    isbn character varying(20) NOT NULL
);


ALTER TABLE public.books OWNER TO postgres;

--
-- Name: lendings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lendings (
    id integer,
    id_books integer,
    id_member integer,
    data_lending date,
    data_return date
);


ALTER TABLE public.lendings OWNER TO postgres;

--
-- Name: libros_idLibro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.books ALTER COLUMN id_books ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."libros_idLibro_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: members; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.members (
    id_member integer NOT NULL,
    name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    phone integer NOT NULL,
    email character varying(30) NOT NULL
);


ALTER TABLE public.members OWNER TO postgres;

--
-- Name: socios_idSocio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.members ALTER COLUMN id_member ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."socios_idSocio_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--
INSERT INTO public.books (title, author, isbn, status)
VALUES 
('La Odisea', 'Homero', '000-0000-00-001', 'Disponible'),
('Romeo y Julieta', 'William Shakespeare', '000-0000-00-002', 'En préstamo'),
('Moby Dick', 'Herman Melville', '000-0000-00-003', 'Disponible'),
('La metamorfosis', 'Franz Kafka', '000-0000-00-004', 'Disponible'),
('La sombra del viento', 'Carlos Ruiz Zafón', '000-0000-00-005', 'En préstamo'),
('El principito', 'Antoine de Saint-Exupéry', '000-0000-00-006', 'Disponible'),
('Los miserables', 'Victor Hugo', '000-0000-00-007', 'En préstamo'),
('El gran Gatsby', 'F. Scott Fitzgerald', '000-0000-00-008', 'Disponible'),
('Anna Karenina', 'Lev Tolstói', '000-0000-00-009', 'Disponible'),
('Las aventuras de Sherlock Holmes', 'Arthur Conan Doyle', '000-0000-00-010', 'En préstamo'),
('El retrato de Dorian Gray', 'Oscar Wilde', '000-0000-00-011', 'Disponible'),
('Frankenstein', 'Mary Shelley', '000-0000-00-012', 'En préstamo'),
('Drácula', 'Bram Stoker', '000-0000-00-013', 'Disponible'),
('Crónica de una muerte anunciada', 'Gabriel García Márquez', '000-0000-00-014', 'Disponible'),
('El nombre de la rosa', 'Umberto Eco', '000-0000-00-015', 'En préstamo'),
('Robinson Crusoe', 'Daniel Defoe', '000-0000-00-016', 'Disponible'),
('El amor en los tiempos del cólera', 'Gabriel García Márquez', '000-0000-00-017', 'En préstamo'),
('El alquimista', 'Paulo Coelho', '000-0000-00-018', 'Disponible'),
('Hamlet', 'William Shakespeare', '000-0000-00-019', 'En préstamo'),
('La iliada', 'Homero', '000-0000-00-020', 'Disponible'),
('Don Quijote de la Mancha', 'Miguel de Cervantes', '000-0000-00-021', 'Disponible'),
('Cien años de soledad', 'Gabriel García Márquez', '000-0000-00-022', 'En préstamo'),
('Orgullo y prejuicio', 'Jane Austen', '000-0000-00-023', 'Disponible'),
('1984', 'George Orwell', '000-0000-00-024', 'Disponible'),
('El guardián entre el centeno', 'J.D. Salinger', '000-0000-00-025', 'Disponible'),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', '000-0000-00-026', 'En préstamo'),
('Los juegos del hambre', 'Suzanne Collins', '000-0000-00-027', 'Disponible'),
('El señor de los anillos', 'J.R.R. Tolkien', '000-0000-00-028', 'En préstamo'),
('Matar a un ruiseñor', 'Harper Lee', '000-0000-00-029', 'Disponible'),
('El nombre del viento', 'Patrick Rothfuss', '000-0000-00-030', 'En préstamo'),
('Las crónicas de Narnia', 'C.S. Lewis', '000-0000-00-031', 'Disponible'),
('El código Da Vinci', 'Dan Brown', '000-0000-00-032', 'En préstamo'),
('La ladrona de libros', 'Markus Zusak', '000-0000-00-033', 'Disponible'),
('El perfume', 'Patrick Süskind', '000-0000-00-034', 'En préstamo'),
('La isla del tesoro', 'Robert Louis Stevenson', '000-0000-00-035', 'Disponible'),
('Crimen y castigo', 'Fyodor Dostoevsky', '000-0000-00-036', 'Disponible'),
('Los pilares de la Tierra', 'Ken Follett', '000-0000-00-037', 'En préstamo'),
('Drácula', 'Bram Stoker', '000-0000-00-038', 'Disponible'),
('El retrato de Dorian Gray', 'Oscar Wilde', '000-0000-00-039', 'En préstamo'),
('La sombra del viento', 'Carlos Ruiz Zafón', '000-0000-00-040', 'Disponible'),
('El guardián entre el centeno', 'J.D. Salinger', '000-0000-00-041', 'Disponible'),
('Los juegos del hambre', 'Suzanne Collins', '000-0000-00-042', 'En préstamo'),
('La chica del tren', 'Paula Hawkins', '000-0000-00-043', 'Disponible'),
('La catedral del mar', 'Ildefonso Falcones', '000-0000-00-044', 'En préstamo'),
('La casa de los espíritus', 'Isabel Allende', '000-0000-00-045', 'Disponible'),
('El amor en los tiempos del cólera', 'Gabriel García Márquez', '000-0000-00-046', 'En préstamo'),
('Los hombres que no amaban a las mujeres', 'Stieg Larsson', '000-0000-00-047', 'Disponible'),
('El nombre del viento', 'Patrick Rothfuss', '000-0000-00-048', 'En préstamo'),
('El club de la lucha', 'Chuck Palahniuk', '000-0000-00-049', 'Disponible'),
('Las uvas de la ira', 'John Steinbeck', '000-0000-00-050', 'En préstamo'),
('Rebelión en la granja', 'George Orwell', '000-0000-00-051', 'Disponible'),
('La ladrona de libros', 'Markus Zusak', '000-0000-00-052', 'En préstamo'),
('El perfume', 'Patrick Süskind', '000-0000-00-053', 'Disponible'),
('La naranja mecánica', 'Anthony Burgess', '000-0000-00-054', 'En préstamo'),
('La chica que soñaba con una cerilla', 'Stieg Larsson', '000-0000-00-055', 'Disponible'),
('Rayuela', 'Julio Cortázar', '000-0000-00-056', 'En préstamo'),
('El hobbit', 'J.R.R. Tolkien', '000-0000-00-057', 'Disponible'),
('Donde los árboles cantan', 'Laura Gallego', '000-0000-00-058', 'En préstamo'),
('El alquimista', 'Paulo Coelho', '000-0000-00-059', 'Disponible'),
('El código Da Vinci', 'Dan Brown', '000-0000-00-060', 'Disponible');


INSERT INTO public.members (name, last_name, phone, email)
VALUES
    ('Pedro', 'Martínez', 123456789, 'pedro@correo.com'),
    ('Ana', 'Lopez', 987654321, 'ana@correo.com'),
    ('María', 'Rodriguez', 456789123, 'maria@correo.com'),
    ('Luis', 'Perez', 112233445, 'luis@correo.com'),
    ('Juan', 'Garcia', 998877665, 'juan@correo.com'),
    ('Julia', 'Sánchez', 556677889, 'julia@correo.com');

SELECT pg_catalog.setval('public."libros_idLibro_seq"', 60, true);


--
-- Name: socios_idSocio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."socios_idSocio_seq"', 8, true);


--
-- Name: books libros_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT libros_pkey PRIMARY KEY (id_books);


--
-- Name: members socios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.members
    ADD CONSTRAINT socios_pkey PRIMARY KEY (id_member);


--
-- Name: lendings id_books; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lendings
    ADD CONSTRAINT id_books FOREIGN KEY (id_books) REFERENCES public.books(id_books) NOT VALID;


--
-- Name: lendings id_member; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lendings
    ADD CONSTRAINT id_member FOREIGN KEY (id_member) REFERENCES public.members(id_member) NOT VALID;


--
-- PostgreSQL database dump complete
--

