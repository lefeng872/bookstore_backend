from pymongo import MongoClient
from py2neo import Graph

def clear_mongodb():
    try:
        # 连接到 MongoDB (默认端口 27017)
        client = MongoClient("mongodb://localhost:27017/")

        # 检查是否存在名为 'rpa' 的数据库
        if "rpa" in client.list_database_names():
            # 删除数据库 'rpa'
            client.drop_database("rpa")
            print("Cleared MongoDB database: rpa")
        else:
            print("Database 'rpa' does not exist in MongoDB.")

        client.close()
    except Exception as e:
        print(f"Error clearing MongoDB: {e}")

def clear_neo4j():
    try:
        # 使用 py2neo 连接到 Neo4j (默认端口 7687)
        graph = Graph("bolt://localhost:7687", auth=("neo4j", "12345678")) # 替换为实际用户名和密码

        # 执行清空数据库的查询
        graph.run("MATCH (n) DETACH DELETE n")
        print("Cleared Neo4j database")

    except Exception as e:
        print(f"Error clearing Neo4j: {e}")

if __name__ == "__main__":
    clear_mongodb()
    clear_neo4j()
