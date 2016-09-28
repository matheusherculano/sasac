INSERT INTO sasac.avaliacao (descricao, dt_disponibilidade, publicado, txt_resposta_negativa, txt_resposta_neutra, txt_resposta_postivia, titulo, repeticao_id, usuario_id) 
	VALUES ('Qual a opinião sobre a limpeza e a organização dos banheiros', '2016-09-28', true, 'Ruim', 'Não tenho opinião', 'Boa', 'Limpeza dos banheiros', 1, 1);

INSERT INTO sasac.periodo (dt_publicacao, respostas_negativas, respostas_neutras, respostas_positivas, avaliacao_id) 
	VALUES ('2016-09-27', 1, 0, 2, 1);
INSERT INTO sasac.periodo (dt_publicacao, respostas_negativas, respostas_neutras, respostas_positivas, avaliacao_id) 
	VALUES ('2016-10-04', 1, 1, 1, 1);
INSERT INTO sasac.periodo (dt_publicacao, respostas_negativas, respostas_neutras, respostas_positivas, avaliacao_id) 
	VALUES ('2016-10-11', 0, 0, 3, 1);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (1, 1);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (2, 1);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (3, 1);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (1, 2);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (2, 2);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (3, 2);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (1, 3);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (2, 3);
INSERT INTO sasac.usuario_periodo (usuario_id, periodo_id) 
	VALUES (3, 3);