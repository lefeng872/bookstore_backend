import mysql.connector
from pymongo import MongoClient

# MySQL 配置
mysql_config = {
    'host': 'localhost',
    'user': 'root',
    'password': 'headmaster',
    'database': 'bookstore'
}

# MongoDB 配置
mongo_config = {
    'host': 'localhost',
    'port': 27017,
    'database': 'bookstore',
    'collection': 'book_images'
}

def fetch_data_from_mysql():
    try:
        # 连接 MySQL 数据库
        mysql_conn = mysql.connector.connect(**mysql_config)
        cursor = mysql_conn.cursor(dictionary=True)
        query = "SELECT id, image FROM book"
        cursor.execute(query)
        # 获取所有结果
        records = cursor.fetchall()
        cursor.close()
        mysql_conn.close()
        return records
    except mysql.connector.Error as err:
        print(f"Error: {err}")
        return []

def insert_data_into_mongo(data):
    try:
        # 连接 MongoDB
        client = MongoClient(mongo_config['host'], mongo_config['port'])
        mongo_db = client[mongo_config['database']]
        collection = mongo_db[mongo_config['collection']]
        # 插入数据
        if data:
            collection.insert_many(data)
            print(f"Inserted {len(data)} records into MongoDB.")
        else:
            print("No data to insert.")
        client.close()
    except Exception as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    # 从 MySQL 获取数据
    records = fetch_data_from_mysql()
    if records:
        # 将数据存入 MongoDB
        insert_data_into_mongo(records)
    else:
        print("No data fetched from MySQL.")
