
INSERT INTO Categoria (nome, descricao)
VALUES
    ('Eletrônicos', 'Dispositivos e aparelhos eletrônicos'),
    ('Celulares', 'Smartphones e acessórios'),
    ('Informática', 'Computadores, notebooks e periféricos'),
    ('Roupas', 'Moda masculina e feminina'),
    ('Calçados', 'Sapatos, tênis e sandálias');

INSERT INTO Administrador (nome, email, senha_hash, nivel_acesso)
VALUES 
    ('Carlos Silva', 'carlos.silva@email.com', 'senha_hash_123', 'gerente'),
    ('Maria Oliveira', 'maria.oliveira@email.com', 'senha_hash_456', 'vendedor'),
    ('João Santos', 'joao.santos@email.com', 'senha_hash_789', 'suporte'),
    ('Ana Souza', 'ana.souza@email.com', 'senha_hash_321', 'gerente'),
    ('Pedro Lima', 'pedro.lima@email.com', 'senha_hash_654', 'vendedor');

INSERT INTO Cliente (nome, email, senha_hash, telefone, data_criacao, status)
VALUES 
    ('Carlos Silva', 'carlos.silva@email.com', 'senha_hash_123', '11987654321', '2025-09-17 08:30:00', 'ativo'),
    ('Maria Oliveira', 'maria.oliveira@email.com', 'senha_hash_456', '11998765432', '2025-09-17 09:00:00', 'ativo'),
    ('João Santos', 'joao.santos@email.com', 'senha_hash_789', '11991234567', '2025-09-17 10:15:00', 'inativo'),
    ('Ana Souza', 'ana.souza@email.com', 'senha_hash_321', '11995432345', '2025-09-17 11:45:00', 'ativo'),
    ('Pedro Lima', 'pedro.lima@email.com', 'senha_hash_654', '11996543210', '2025-09-17 12:00:00', 'inativo');

INSERT INTO Endereco (cliente_id, logradouro, numero, complemento, bairro, cidade, estado, cep, tipo)
VALUES
    (1, 'Rua das Flores', '123', 'Apto 101', 'Centro', 'São Paulo', 'SP', '01001-000', 'residencial'),
    (2, 'Av. Paulista', '1000', 'Conj. 501', 'Bela Vista', 'São Paulo', 'SP', '01310-100', 'comercial'),
    (3, 'Rua das Acácias', '456', NULL, 'Jardim América', 'Rio de Janeiro', 'RJ', '22041-001', 'residencial'),
    (4, 'Praça da Sé', '789', 'Sala 5', 'Sé', 'São Paulo', 'SP', '01001-000', 'comercial'),
    (5, 'Rua da Liberdade', '321', NULL, 'Liberdade', 'São Paulo', 'SP', '01503-000', 'outro');

INSERT INTO Produto (nome, descricao, preco, estoque, imagem_url, data_cadastro, categoria_id, status)
VALUES
    ('Produto A', 'Descrição do Produto A', 99.99, 50, 'http://example.com/produto-a.jpg', '2025-09-17 08:30:00', 1, 'ativo'),
    ('Produto B', 'Descrição do Produto B', 149.90, 30, 'http://example.com/produto-b.jpg', '2025-09-17 09:00:00', 2, 'ativo'),
    ('Produto C', 'Descrição do Produto C', 49.50, 100, 'http://example.com/produto-c.jpg', '2025-09-17 10:15:00', 3, 'inativo'),
    ('Produto D', 'Descrição do Produto D', 199.00, 20, 'http://example.com/produto-d.jpg', '2025-09-17 11:45:00', 1, 'ativo'),
    ('Produto E', 'Descrição do Produto E', 59.99, 75, 'http://example.com/produto-e.jpg', '2025-09-17 12:00:00', 2, 'inativo');

INSERT INTO Carrinho (cliente_id, data_criacao, status)
VALUES
    (1, '2025-09-17 08:00:00', 'aberto'),
    (2, '2025-09-17 08:30:00', 'finalizado'),
    (3, '2025-09-17 09:00:00', 'aberto'),
    (4, '2025-09-17 09:30:00', 'finalizado'),
    (5, '2025-09-17 10:00:00', 'aberto');

INSERT INTO CarrinhoItem (carrinho_id, produto_id, quantidade, preco_unitario)
VALUES
    (1, 1, 2, 99.99),
    (1, 2, 1, 149.90),
    (2, 3, 3, 49.50),
    (3, 4, 1, 199.00),
    (4, 5, 2, 59.99);

INSERT INTO Avaliacao (cliente_id, produto_id, nota, comentario, data_avaliacao)
VALUES
    (1, 2, 5, 'Produto bom, mas poderia melhorar.', '2025-09-17 08:30:00'),
    (2, 3, 4, 'O produto atendeu minhas expectativas, mas demorou um pouco para chegar.', '2025-09-17 09:00:00'),
    (3, 1, 3, 'O produto não é como eu esperava, não gostei muito.', '2025-09-17 10:15:00'),
    (4, 2, 2, 'Produto com defeito, não funcionou corretamente.', '2025-09-17 11:45:00'),
    (5, 3, 5, 'Excelente produto, recomendo muito!', '2025-09-17 12:00:00');

INSERT INTO Pedido (cliente_id, endereco_entrega_id, data_pedido, valor_total, status_pedido)
VALUES
    (1, 1, '2025-09-17 08:00:00', 250.00, 'pago'),
    (2, 2, '2025-09-16 14:20:00', 150.50, 'pendente'),
    (3, 3, '2025-09-15 10:30:00', 300.75, 'entregue'),
    (4, 4, '2025-09-17 09:40:00', 120.00, 'cancelado'),
    (5, 5, '2025-09-15 11:00:00', 450.00, 'enviado');

INSERT INTO PedidoItem (pedido_id, produto_id, quantidade, preco_unitario)
VALUES
    (1, 1, 2, 99.99),
    (1, 2, 1, 49.99),
    (2, 3, 3, 50.00),
    (3, 4, 1, 199.00),
    (5, 5, 2, 59.99);

INSERT INTO Entrega (pedido_id, codigo_rastreamento, transportadora, status_entrega, data_envio, data_entrega_prevista, data_entrega_real)
VALUES
    (1, 'TRACK12345', 'Transportadora A', 'pendente', '2025-09-17 08:00:00', '2025-09-22', '2025-09-19'),
    (2, 'TRACK67890', 'Transportadora B', 'em_transito', '2025-09-16 14:30:00', '2025-09-21', '2025-09-19'),
    (3, 'TRACK11121', 'Transportadora C', 'entregue', '2025-09-15 09:00:00', '2025-09-20', '2025-09-19'),
    (4, 'TRACK31415', 'Transportadora D', 'em_transito', '2025-09-16 10:00:00', '2025-09-23', '2025-09-20'),
    (5, 'TRACK33215', 'Transportadora E', 'em_transito', '2025-09-16 11:00:00', '2025-09-24', '2025-09-21');

INSERT INTO Pagamento (pedido_id, forma_pagamento, status_pagamento, valor, data_pagamento) VALUES
(1, 'cartao', 'aprovado', 150.00, '2025-09-16T10:30:00'),
(2, 'boleto', 'pendente', 299.90, '2025-09-17T14:15:00'),
(3, 'pix', 'aprovado', 75.50, '2025-09-17T09:00:00'),
(4, 'cartao', 'recusado', 199.99, '2025-09-16T16:45:00'),
(5, 'pix', 'pendente', 49.90, '2025-09-17T12:00:00');
