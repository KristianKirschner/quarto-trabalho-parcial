-- 1. Inserir os clientes
INSERT INTO Cliente (id, nome, email, senha_hash, telefone, data_criacao, status) VALUES
(1, 'João Silva', 'joao.silva@email.com', 'hash1', '11999999999', '2024-01-01 10:00:00', 'ativo'),
(2, 'Maria Oliveira', 'maria.oliveira@email.com', 'hash2', '21988888888', '2024-01-02 11:00:00', 'ativo'),
(3, 'Carlos Souza', 'carlos.souza@email.com', 'hash3', '31977777777', '2024-01-03 12:00:00', 'ativo'),
(4, 'Ana Paula', 'ana.paula@email.com', 'hash4', '41966666666', '2024-01-04 13:00:00', 'ativo'),
(5, 'Pedro Santos', 'pedro.santos@email.com', 'hash5', '51955555555', '2024-01-05 14:00:00', 'ativo');

-- 2. Inserir os endereços
INSERT INTO Endereco (id, cliente_id, logradouro, numero, complemento, bairro, cidade, estado, cep, tipo) VALUES
(1, 1, 'Rua das Flores', '123', NULL, 'Jardim Primavera', 'São Paulo', 'SP', '01001-000', 'residencial'),
(2, 1, 'Av. Paulista', '1000', 'Apto 101', 'Bela Vista', 'São Paulo', 'SP', '01310-000', 'comercial'),
(3, 2, 'Rua Central', '456', NULL, 'Centro', 'Rio de Janeiro', 'RJ', '20010-000', 'residencial'),
(4, 3, 'Av. Brasil', '789', 'Sala 3', 'Copacabana', 'Rio de Janeiro', 'RJ', '22040-001', 'comercial'),
(5, 4, 'Rua Nova', '321', NULL, 'Centro', 'Belo Horizonte', 'MG', '30110-001', 'residencial');

-- 3. Inserir as categorias
INSERT INTO Categoria (id, nome, descricao, categoria_pai_id) VALUES
(1, 'Eletrônicos', 'Produtos eletrônicos em geral', 2),
(2, 'Celulares', 'Smartphones e acessórios', 1),
(3, 'Informática', 'Computadores e acessórios', 1),
(4, 'Roupas', 'Vestuário masculino e feminino', 2),
(5, 'Calçados', 'Sapatos, tênis e sandálias', 1);

-- 4. Inserir os produtos
INSERT INTO Produto (id, nome, descricao, preco, estoque, categoria_id, imagem_url, data_cadastro, status) VALUES
(1, 'iPhone 14', 'Smartphone Apple iPhone 14 128GB', 4999.00, 50, 2, 'url1', '2024-01-01 09:00:00', 'ativo'),
(2, 'Notebook Dell', 'Notebook Dell Inspiron 15', 3499.00, 30, 3, 'url2', '2024-01-02 10:00:00', 'ativo'),
(3, 'Camiseta Polo', 'Camiseta Polo masculina tamanho M', 79.90, 100, 4, 'url3', '2024-01-03 11:00:00', 'ativo'),
(4, 'Tênis Nike', 'Tênis esportivo Nike Air Max', 299.90, 80, 5, 'url4', '2024-01-04 12:00:00', 'ativo'),
(5, 'Fone de Ouvido', 'Fone Bluetooth Sony', 199.90, 150, 1, 'url5', '2024-01-05 13:00:00', 'ativo');

-- 5. Inserir os carrinhos
INSERT INTO Carrinho (id, cliente_id, data_criacao, status) VALUES
(1, 1, '2024-02-01 08:00:00', 'aberto'),
(2, 2, '2024-02-02 09:00:00', 'aberto'),
(3, 3, '2024-02-03 10:00:00', 'finalizado'),
(4, 4, '2024-02-04 11:00:00', 'finalizado'),
(5, 5, '2024-02-05 12:00:00', 'aberto');

-- 6. Inserir os itens dos carrinhos
INSERT INTO CarrinhoItem (id, carrinho_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 1, 1, 4999.00),
(2, 1, 5, 2, 199.90),
(3, 2, 3, 3, 79.90),
(4, 3, 2, 1, 3499.00),
(5, 4, 4, 1, 299.90);

-- 7. Inserir os pedidos
INSERT INTO Pedido (id, cliente_id, endereco_entrega_id, data_pedido, status_pedido, valor_total) VALUES
(1, 3, 4, '2024-02-10 14:00:00', 'pago', 3499.00),
(2, 4, 5, '2024-02-11 15:00:00', 'enviado', 299.90),
(3, 1, 1, '2024-02-12 16:00:00', 'pendente', 5198.80),
(4, 2, 3, '2024-02-13 17:00:00', 'cancelado', 239.70),
(5, 5, 5, '2024-02-14 18:00:00', 'entregue', 79.90);

-- 8. Inserir os itens dos pedidos
INSERT INTO PedidoItem (id, pedido_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 2, 1, 3499.00),
(2, 2, 4, 1, 299.90),
(3, 3, 1, 1, 4999.00),
(4, 3, 5, 1, 199.90),
(5, 4, 3, 3, 79.90);

-- 9. Inserir os pagamentos
INSERT INTO Pagamento (id, pedido_id, forma_pagamento, status_pagamento, valor, data_pagamento) VALUES
(1, 1, 'cartao', 'aprovado', 3499.00, '2024-02-10 14:05:00'),
(2, 2, 'boleto', 'aprovado', 299.90, '2024-02-11 15:10:00'),
(3, 3, 'pix', 'pendente', 5198.80, '2024-02-12 17:30:00'),
(4, 4, 'cartao', 'recusado', 239.70, '2024-02-13 17:10:00'),
(5, 5, 'pix', 'aprovado', 79.90, '2024-02-14 18:15:00');

-- 10. Inserir as entregas
INSERT INTO Entrega (id, pedido_id, codigo_rastreamento, transportadora, status_entrega, data_envio, data_entrega_prevista, data_entrega_real) VALUES
(1, 1, 'BR12345678', 'Correios', 'entregue', '2024-02-10 15:00:00', '2024-02-12 18:00:00', '2024-02-12 17:30:00'),
(2, 2, 'BR23456789', 'FedEx', 'em trânsito', '2024-02-11 16:00:00', '2024-02-14 18:00:00', '2024-02-12 17:30:00'),
(3, 3, 'BR34567890', 'DHL', 'pendente', '2024-02-13 10:00:00', '2024-02-15 15:00:00', '2024-02-12 17:30:00'),
(4, 4, 'BR45678901', 'Correios', 'entregue', '2024-02-14 11:00:00', '2024-02-16 17:00:00', '2024-02-16 16:45:00'),
(5, 5, 'BR56789012', 'UPS', 'cancelada', '2024-02-15 12:00:00', '2024-02-18 19:00:00', '2024-02-12 17:30:00');
