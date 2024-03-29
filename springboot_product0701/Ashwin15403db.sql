toc.dat                                                                                             0000600 0004000 0002000 00000007555 14356525452 0014466 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP                            {            Ashwin15403db    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         �           1262    32912    Ashwin15403db    DATABASE     s   CREATE DATABASE "Ashwin15403db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "Ashwin15403db";
                postgres    false         �            1259    33057    book    TABLE     �   CREATE TABLE public.book (
    book_id bigint NOT NULL,
    book_name character varying(255),
    unit_price double precision NOT NULL
);
    DROP TABLE public.book;
       public         heap    postgres    false         �            1259    33064    customer    TABLE     �   CREATE TABLE public.customer (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_email character varying(255),
    customer_name character varying(255)
);
    DROP TABLE public.customer;
       public         heap    postgres    false         �            1259    33062    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false         �            1259    32913    product    TABLE     �   CREATE TABLE public.product (
    product_id bigint NOT NULL,
    image_url character varying(255),
    product_description character varying(255),
    product_name character varying(255),
    unit_price double precision NOT NULL
);
    DROP TABLE public.product;
       public         heap    postgres    false         �          0    33057    book 
   TABLE DATA           >   COPY public.book (book_id, book_name, unit_price) FROM stdin;
    public          postgres    false    201       2997.dat �          0    33064    customer 
   TABLE DATA           `   COPY public.customer (customer_id, customer_address, customer_email, customer_name) FROM stdin;
    public          postgres    false    203       2999.dat �          0    32913    product 
   TABLE DATA           g   COPY public.product (product_id, image_url, product_description, product_name, unit_price) FROM stdin;
    public          postgres    false    200       2996.dat �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 2, true);
          public          postgres    false    202         /           2606    33061    book book_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (book_id);
 8   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pkey;
       public            postgres    false    201         1           2606    33071    customer customer_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    203         -           2606    32920    product product_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    200                                                                                                                                                           2997.dat                                                                                            0000600 0004000 0002000 00000000005 14356525452 0014272 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           2999.dat                                                                                            0000600 0004000 0002000 00000000144 14356525452 0014300 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	mulund	As@gmail.com	ashwin
2	mulund west	As@mastek.com	ashwinkumar
3	cst	as@	as
4	cst	as@	as
\.


                                                                                                                                                                                                                                                                                                                                                                                                                            2996.dat                                                                                            0000600 0004000 0002000 00000000346 14356525452 0014301 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1.jpg	this is laptop	lenovo	23
6	1.jpg	this is laptop	lenovo	23
7	1.jpg	this is laptop	lenovo	23
4	1.sdjkskjpg	this is ndskfnkdf	laptop	23
3	1.sdjkskjpg	this is ndskfnkdf	laptop	23
2	1.sdjkskjpg	this is ndskfnkdf	laptop	23
\.


                                                                                                                                                                                                                                                                                          restore.sql                                                                                         0000600 0004000 0002000 00000007726 14356525452 0015413 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

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

DROP DATABASE "Ashwin15403db";
--
-- Name: Ashwin15403db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Ashwin15403db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';


ALTER DATABASE "Ashwin15403db" OWNER TO postgres;

\connect "Ashwin15403db"

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
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    book_id bigint NOT NULL,
    book_name character varying(255),
    unit_price double precision NOT NULL
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_email character varying(255),
    customer_name character varying(255)
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    product_id bigint NOT NULL,
    image_url character varying(255),
    product_description character varying(255),
    product_name character varying(255),
    unit_price double precision NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (book_id, book_name, unit_price) FROM stdin;
\.
COPY public.book (book_id, book_name, unit_price) FROM '$$PATH$$/2997.dat';

--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_id, customer_address, customer_email, customer_name) FROM stdin;
\.
COPY public.customer (customer_id, customer_address, customer_email, customer_name) FROM '$$PATH$$/2999.dat';

--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (product_id, image_url, product_description, product_name, unit_price) FROM stdin;
\.
COPY public.product (product_id, image_url, product_description, product_name, unit_price) FROM '$$PATH$$/2996.dat';

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 2, true);


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (book_id);


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          