from py2neo import Graph, Node, Relationship

# 配置 Neo4j 连接信息
NEO4J_URI = "bolt://localhost:7687"  # Neo4j 的 Bolt URI
NEO4J_USER = "neo4j"                 # Neo4j 用户名
NEO4J_PASSWORD = "12345678"          # Neo4j 密码

# 类别列表
categories = [
    "编程",
    "儿童文学",
    "魔幻小说",
    "科幻小说",
    "世界名著",
    "社会小说",
    "悬疑/推理小说",
    "青春文学",
    "传记文学",
    "中小学教辅",
    "古籍",
    "武侠小说",
    "伟人传记"
]

# 自定义类别之间的关系
relationships = [
    ("社会小说", "世界名著"),
    ("悬疑/推理小说", "社会小说"),
    ("青春文学", "社会小说"),
    ("传记文学", "伟人传记"),
    ("科幻小说", "魔幻小说"),
    ("武侠小说", "古籍"),
    ("中小学教辅", "编程"),
    ("编程", "科幻小说"),
    ("儿童文学", "青春文学"),
    ("青春文学", "武侠小说"),
    ("伟人传记", "社会小说"),
    ("魔幻小说", "悬疑/推理小说")
]

# 初始化图数据库
graph = Graph(NEO4J_URI, auth=(NEO4J_USER, NEO4J_PASSWORD))

# 清空现有数据（可选）
def clear_graph():
    graph.delete_all()
    print("Graph database cleared.")

# 创建类别节点
def create_categories():
    for category in categories:
        node = Node("Category", name=category)
        graph.merge(node, "Category", "name")  # merge 确保唯一性
    print("Categories added successfully!")

# 创建类别之间的关系
def create_relationships():
    for child, parent in relationships:
        child_node = graph.nodes.match("Category", name=child).first()
        parent_node = graph.nodes.match("Category", name=parent).first()
        if child_node and parent_node:
            rel = Relationship(parent_node, "INCLUDES", child_node)
            graph.merge(rel)  # merge 确保关系唯一性
    print("Relationships added successfully!")

# 初始化数据库
def init_database():
    clear_graph()            # 清空数据库（可选）
    create_categories()      # 添加节点
    create_relationships()   # 添加关系
    print("Database initialization complete.")

# 执行脚本
if __name__ == "__main__":
    init_database()
