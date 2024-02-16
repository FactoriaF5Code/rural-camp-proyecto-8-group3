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

COPY public.books (id_books, title, author, status, isbn) FROM stdin;
1	La Odisea	Homero	Disponible	000-0000-00-001
2	Romeo y Julieta	William Shakespeare	En pr├®stamo	000-0000-00-002
3	Moby Dick	Herman Melville	Disponible	000-0000-00-003
4	La metamorfosis	Franz Kafka	Disponible	000-0000-00-004
5	La sombra del viento	Carlos Ruiz Zaf├│n	En pr├®stamo	000-0000-00-005
6	El principito	Antoine de Saint-Exup├®ry	Disponible	000-0000-00-006
7	Los miserables	Victor Hugo	En pr├®stamo	000-0000-00-007
8	El gran Gatsby	F. Scott Fitzgerald	Disponible	000-0000-00-008
9	Anna Karenina	Lev Tolst├│i	Disponible	000-0000-00-009
10	Las aventuras de Sherlock Holmes	Arthur Conan Doyle	En pr├®stamo	000-0000-00-010
11	El retrato de Dorian Gray	Oscar Wilde	Disponible	000-0000-00-011
12	Frankenstein	Mary Shelley	En pr├®stamo	000-0000-00-012
13	Dr├ícula	Bram Stoker	Disponible	000-0000-00-013
14	Cr├│nica de una muerte anunciada	Gabriel Garc├¡a M├írquez	Disponible	000-0000-00-014
15	El nombre de la rosa	Umberto Eco	En pr├®stamo	000-0000-00-015
16	Robinson Crusoe	Daniel Defoe	Disponible	000-0000-00-016
17	El amor en los tiempos del c├│lera	Gabriel Garc├¡a M├írquez	En pr├®stamo	000-0000-00-017
18	El alquimista	Paulo Coelho	Disponible	000-0000-00-018
19	Hamlet	William Shakespeare	En pr├®stamo	000-0000-00-019
20	La iliada	Homero	Disponible	000-0000-00-020
21	Don Quijote de la Mancha	Miguel de Cervantes	Disponible	000-0000-00-021
22	Cien a├▒os de soledad	Gabriel Garc├¡a M├írquez	En pr├®stamo	000-0000-00-022
23	Orgullo y prejuicio	Jane Austen	Disponible	000-0000-00-023
24	1984	George Orwell	Disponible	000-0000-00-024
25	El guardi├ín entre el centeno	J.D. Salinger	Disponible	000-0000-00-025
26	Harry Potter y la piedra filosofal	J.K. Rowling	En pr├®stamo	000-0000-00-026
27	Los juegos del hambre	Suzanne Collins	Disponible	000-0000-00-027
28	El se├▒or de los anillos	J.R.R. Tolkien	En pr├®stamo	000-0000-00-028
29	Matar a un ruise├▒or	Harper Lee	Disponible	000-0000-00-029
30	El nombre del viento	Patrick Rothfuss	En pr├®stamo	000-0000-00-030
31	Las cr├│nicas de Narnia	C.S. Lewis	Disponible	000-0000-00-031
32	El c├│digo Da Vinci	Dan Brown	En pr├®stamo	000-0000-00-032
33	La ladrona de libros	Markus Zusak	Disponible	000-0000-00-033
34	El perfume	Patrick S├╝skind	En pr├®stamo	000-0000-00-034
35	La isla del tesoro	Robert Louis Stevenson	Disponible	000-0000-00-035
36	Crimen y castigo	Fyodor Dostoevsky	Disponible	000-0000-00-036
37	Los pilares de la Tierra	Ken Follett	En pr├®stamo	000-0000-00-037
38	Dr├ícula	Bram Stoker	Disponible	000-0000-00-038
39	El retrato de Dorian Gray	Oscar Wilde	En pr├®stamo	000-0000-00-039
40	La sombra del viento	Carlos Ruiz Zaf├│n	Disponible	000-0000-00-040
41	El guardi├ín entre el centeno	J.D. Salinger	Disponible	000-0000-00-041
42	Los juegos del hambre	Suzanne Collins	En pr├®stamo	000-0000-00-042
43	La chica del tren	Paula Hawkins	Disponible	000-0000-00-043
44	La catedral del mar	Ildefonso Falcones	En pr├®stamo	000-0000-00-044
45	La casa de los esp├¡ritus	Isabel Allende	Disponible	000-0000-00-045
46	El amor en los tiempos del c├│lera	Gabriel Garc├¡a M├írquez	En pr├®stamo	000-0000-00-046
47	Los hombres que no amaban a las mujeres	Stieg Larsson	Disponible	000-0000-00-047
48	El nombre del viento	Patrick Rothfuss	En pr├®stamo	000-0000-00-048
49	El club de la lucha	Chuck Palahniuk	Disponible	000-0000-00-049
50	Las uvas de la ira	John Steinbeck	En pr├®stamo	000-0000-00-050
51	Rebeli├│n en la granja	George Orwell	Disponible	000-0000-00-051
52	La ladrona de libros	Markus Zusak	En pr├®stamo	000-0000-00-052
53	El perfume	Patrick S├╝skind	Disponible	000-0000-00-053
54	La naranja mec├ínica	Anthony Burgess	En pr├®stamo	000-0000-00-054
55	La chica que so├▒aba con una cerilla	Stieg Larsson	Disponible	000-0000-00-055
56	Rayuela	Julio Cort├ízar	En pr├®stamo	000-0000-00-056
57	El hobbit	J.R.R. Tolkien	Disponible	000-0000-00-057
58	Donde los ├írboles cantan	Laura Gallego	En pr├®stamo	000-0000-00-058
59	El alquimista	Paulo Coelho	Disponible	000-0000-00-059
60	El c├│digo Da Vinci	Dan Brown	Disponible	000-0000-00-060
\.


--
-- Data for Name: lendings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lendings (id, id_books, id_member, data_lending, data_return) FROM stdin;
\.


--
-- Data for Name: members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.members (id_member, name, last_name, phone, email) FROM stdin;
1	Pedro	Mart├¡nez	123456789	pedro@correo.com
2	Ana	Lopez	987654321	ana@correo.com
3	Mar├¡a	Rodriguez	456789123	maria@correo.com
4	Luis	Perez	112233445	luis@correo.com
5	Juan	Garcia	998877665	juan@correo.com
6	Julia	S├ínchez	556677889	julia@correo.com
7	paquito	chocolatero	685986854	paquitoelchocolatero@gmail.com
8	paquita	chocolatera	685986874	paquitoelchocolatera@gmail.com
\.


--
-- Name: libros_idLibro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

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

